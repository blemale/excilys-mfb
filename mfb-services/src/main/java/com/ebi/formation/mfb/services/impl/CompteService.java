package com.ebi.formation.mfb.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.services.ICompteService;

/**
 * Implémentation du service associé à CompteDao
 * 
 * @author excilys
 * 
 */
@Service
@Transactional(readOnly = true)
public class CompteService implements ICompteService {

	private final Logger logger = LoggerFactory.getLogger(CompteService.class);
	@Autowired
	private ICompteDao compteDao;
	@Autowired
	private IPersonDao personDao;
	@Autowired
	private IOperationDao operationDao;
	private static final int LENGTH_NUM_COMPTE = 8;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#findComptesByUsername(java.lang.String)
	 */
	@Override
	public List<Compte> findComptesByUsername(String username) {
		logger.debug("findComptesByUsername(username:{})", username);
		return compteDao.findComptesByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#checkCompteOwnershipByUsernameAndCompteId(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		logger.debug("checkCompteOwnershipByUsernameAndCompteId(username:{},compteId:{})", username, compteId);
		return compteDao.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#getCompteById(java.lang.Long)
	 */
	@Override
	public Compte getCompteById(Long id) {
		logger.debug("getCompteById(id:{})", id);
		return compteDao.findCompteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#getCompteByNumeroCompte(java.lang.String)
	 */
	@Override
	public Compte getCompteByNumeroCompte(String numeroCompte) {
		logger.debug("getCompteByNumeroCompte(numeroCompte:{})", numeroCompte);
		return compteDao.findCompteByNumeroCompte(numeroCompte);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#save(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Object[] save(String libelle, String usernamePerson, BigDecimal solde) {
		logger.debug("save(libelle:{}, usernamePerson:{}, solde:{})", new Object[] { libelle, usernamePerson, solde });
		Person p = personDao.findPersonByUsername(usernamePerson);
		if (p == null) {
			return new Object[] { ReturnCodeCompte.OWNER_INEXISTANT };
		}
		Compte compte = new Compte();
		compte.setLabel(libelle);
		compte.addOwner(p);
		compte.setSolde(solde);
		compte.setEncoursCarte(new BigDecimal(0));
		compte.setSoldePrevisionnel(new BigDecimal(0));
		String numCompte = "";
		// génère un numéro de compte et vérifie qu'il n'existe pas déjà !
		do {
			numCompte = this.getNumeroCompte();
		} while (compteDao.findCompteByNumeroCompte(numCompte) != null);
		compte.setNumeroCompte(numCompte);
		compteDao.save(compte);
		return new Object[] { ReturnCodeCompte.OK, numCompte };
	}

	/**
	 * Méthode permettant de générer une String aléatoire
	 * 
	 * @return une chaine de caractères aléatoire composée de chiffres
	 */
	private String getNumeroCompte() {
		String chars = "0123456789";
		StringBuilder res = new StringBuilder("");
		int numI;
		for (int i = 0; i < LENGTH_NUM_COMPTE; i++) {
			numI = (int) Math.floor(Math.random() * 10);
			res.append(chars.charAt(numI));
		}
		return res.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#findAllComptes()
	 */
	@Override
	public List<Compte> findAllComptes() {
		return compteDao.findAllComptes();
	}
}
