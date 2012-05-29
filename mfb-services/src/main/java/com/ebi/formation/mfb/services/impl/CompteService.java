package com.ebi.formation.mfb.services.impl;

import java.util.List;

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

	@Autowired
	ICompteDao compteDao;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#findComptesByUsername(java.lang.String)
	 */
	@Override
	public List<Compte> findComptesByUsername(String username) {
		return compteDao.findComptesByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#checkCompteOwnershipByUsernameAndCompteId(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		return compteDao.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#getCompteById(java.lang.Long)
	 */
	@Override
	public Compte getCompteById(Long id) {
		return compteDao.findCompteById(id);
	}
}
