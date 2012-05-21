package com.ebi.formation.mfb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.IPersonService;

/**
 * Implémentation du service associé à CompteDao
 * 
 * @author excilys
 * 
 */
@Service
@Transactional(readOnly = true)
public class PersonService implements IPersonService {

	@Autowired
	private IPersonDao personDao;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.ICompteService#findCompteByUserId(long)
	 */
	@Override
	public List<Compte> findComptesByUserId(long id) {
		return personDao.findComptesByUserId(id);
	}
}
