package com.ebi.formation.mfb.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.entities.Compte;

/**
 * Implémentation de l'interface ICompteDao
 * 
 * @author excilys
 * @author fguillain
 * 
 */
@Repository
public class CompteDao implements ICompteDao {

	private final Logger logger = LoggerFactory.getLogger(CompteDao.class);
	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findComptesByUsername(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> findComptesByUsername(String username) {
		logger.debug("findComptesByUsername(username:{})", username);
		return em.createNamedQuery("findComptesByUsername").setParameter("username", username).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#checkCompteOwnershipByUsernameAndCompteId(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		logger.debug("checkCompteOwnershipByUsernameAndCompteId(username:{},compteId:{})", username, compteId);
		long result = 0;
		result = em.createNamedQuery("checkCompteOwnershipByUsernameAndCompteId", Long.class)
				.setParameter("username", username).setParameter("compteId", compteId).getSingleResult();
		return result == 0L ? false : true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findCompteById(long)
	 */
	@Override
	public Compte findCompteById(long id) {
		logger.debug("findCompteById(id:{})", id);
		Compte c = null;
		try {
			return em.createNamedQuery("findCompteById", Compte.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException nre) {
			logger.debug("findCompteById(id:{}) : Compte not found.", id);
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findMontantCompteById(java.lang.Long)
	 */
	@Override
	public BigDecimal findMontantCompteById(Long id) {
		logger.debug("findMontantCompteById(id:{})", id);
		return (BigDecimal) em.createNamedQuery("findSoldeCompte").setParameter("id", id).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findCompteByNumeroCompte(java.lang.String)
	 */
	@Override
	public Compte findCompteByNumeroCompte(String numeroCompte) {
		logger.debug("findCompteByNumeroCompte(numeroCompte:{})", numeroCompte);
		Compte c = null;
		try {
			return em.createNamedQuery("findCompteByNumeroCompte", Compte.class)
					.setParameter("numeroCompte", numeroCompte).getSingleResult();
		} catch (NoResultException nre) {
			logger.debug("findCompteByNumeroCompte(numeroCompte:{}) : Compte not found.", numeroCompte);
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findEncoursCarteCompteById(java.lang.Long)
	 */
	@Override
	public BigDecimal findEncoursCarteCompteById(Long id) {
		logger.debug("findEncoursCarteCompteById(id:{})", id);
		return (BigDecimal) em.createNamedQuery("findEncoursCarteCompte").setParameter("id", id).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#save(com.ebi.formation.mfb.entities.Compte)
	 */
	@Override
	public void save(Compte compte) {
		em.persist(compte);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findAllComptes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Compte> findAllComptes() {
		return em.createNamedQuery("findAllComptes").getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#updateCompte(java.lang.Long, java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public void updateCompteSolde(Long id, BigDecimal montant) {
		em.createNamedQuery("updateCompteSolde").setParameter("compteOperationId", id).setParameter("valeur", montant)
				.executeUpdate();
		em.clear();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#updateCompteWithOperationTypeCarte(java.lang.Long,
	 * java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public void updateCompteSoldeAndEncoursCarte(Long id, BigDecimal montant) {
		em.createNamedQuery("updateCompteSoldeAndEncoursCarte").setParameter("compteOperationId", id)
				.setParameter("valeur", montant).executeUpdate();
		em.clear();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#updateCompteEncoursCarteAndSoldePrevisionnel(java.lang.Long,
	 * java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public void updateCompteEncoursCarteAndSoldePrevisionnel(Long id, BigDecimal montant) {
		em.createNamedQuery("updateCompteEncoursCarteAndSoldePrevisionnel").setParameter("compteOperationId", id)
				.setParameter("valeur", montant).executeUpdate();
		em.clear();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#updateCompteSoldePrevisionnel(java.lang.Long, java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public void updateCompteSoldePrevisionnel(Long id, BigDecimal montant) {
		em.createNamedQuery("updateCompteSoldePrevisionnel").setParameter("compteOperationId", id)
				.setParameter("valeur", montant).executeUpdate();
		em.clear();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#updateCompteSoldeAndSoldePrevisionnel(java.lang.Long,
	 * java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public void updateCompteSoldeAndSoldePrevisionnel(Long id, BigDecimal montant) {
		em.createNamedQuery("updateCompteSoldeAndSoldePrevisionnel").setParameter("compteOperationId", id)
				.setParameter("valeur", montant).executeUpdate();
		em.clear();
	}
}
