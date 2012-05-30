package com.ebi.formation.mfb.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.entities.Compte;
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
	ICompteDao compteDao;

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
}
