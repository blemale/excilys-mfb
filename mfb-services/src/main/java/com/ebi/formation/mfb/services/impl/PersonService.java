package com.ebi.formation.mfb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.services.IPersonService;

/**
 * Implémentation du service associé à PersonDao
 * 
 * @author excilys
 * 
 */
@Service
@Transactional(readOnly = true)
public class PersonService implements IPersonService {

	@Autowired
	private IPersonDao personDao;
}
