package com.ebi.formation.mfb.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.dao.IRoleDao;
import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.IPersonService;

/**
 * Implémentation du service associé à PersonDao
 * 
 * @author excilys
 * @author fguillain
 * 
 */
@Service
@Transactional(readOnly = true)
public class PersonService implements IPersonService {

	private final Logger logger = LoggerFactory.getLogger(PersonService.class);
	@Autowired
	private IPersonDao personDao;
	@Autowired
	private IRoleDao roleDao;
	private static final int TAILLE_SHA = 512;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IPersonService#findPersonByUsername(java.lang.String)
	 */
	@Override
	public Person findPersonByUsername(String username) {
		logger.debug("findPersonByUsername(username:{})", username);
		Person p = null;
		try {
			p = personDao.findPersonByUsername(username);
		} catch (NoResultException e) {
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IPersonService#save(com.ebi.formation.mfb.entities.Person)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public ReturnCodePerson save(String username, String firstname, String lastname, String password,
			List<Right> listRights) {
		logger.debug("save(username:{}, firstname:{}, lastname:{}, password:{}, listRights)", new Object[] { username,
				firstname, lastname, password, listRights });
		if (findPersonByUsername(username) != null) {
			return ReturnCodePerson.IDENTICAL_USERNAME;
		}
		Person person = new Person();
		person.setUsername(username);
		person.setFirstName(firstname);
		person.setLastName(lastname);
		person.setPassword(new ShaPasswordEncoder(TAILLE_SHA).encodePassword(password, null));
		Set<Role> setRoles = new HashSet<Role>();
		//
		for (Right r : listRights) {
			try {
				setRoles.add(roleDao.findRoleByRight(r));
			} catch (Exception e) {
				logger.debug("save(username:{}, firstname:{}, lastname:{}, password:{}, listRights) : Role not found",
						new Object[] { username, firstname, lastname, password, listRights });
				return ReturnCodePerson.ROLES_NOT_DEFINED;
			}
		}
		person.setAuthorities(setRoles);
		personDao.save(person);
		return ReturnCodePerson.OK;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IPersonService#findAllPersons()
	 */
	@Override
	public List<Person> findAllPersons() {
		return personDao.findAllPersons();
	}
}
