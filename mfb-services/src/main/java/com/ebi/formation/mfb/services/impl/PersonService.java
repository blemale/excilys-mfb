package com.ebi.formation.mfb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Person;
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

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IPersonService#findPersonByUsername(java.lang.String)
	 */
	@Override
	public Person findPersonByUsername(String username) {
		return personDao.findPersonByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IPersonService#save(com.ebi.formation.mfb.entities.Person)
	 */
	@Override
	public ReturnCodePerson save(String username, String firstname, String lastname, String password) {
		if (findPersonByUsername(username) != null) {
			return ReturnCodePerson.IDENTICAL_USERNAME;
		}
		Person person = new Person();
		person.setUsername(username);
		person.setFirstName(firstname);
		person.setLastName(lastname);
		person.setPassword(new ShaPasswordEncoder(512).encodePassword(password, null));
		personDao.save(person);
		return ReturnCodePerson.OK;
	}
}
