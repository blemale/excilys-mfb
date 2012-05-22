package com.ebi.formation.mfb.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Person;

/**
 * Implémentation de IPersonDAO, via JPA.
 * 
 * @author excilys
 * 
 */
@Repository
public class PersonDao implements IPersonDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IPersonDao#findUserDetailsByUsername(java.lang.String)
	 */
	@Override
	public UserDetails findUserDetailsByUsername(String username) {
		UserDetails user = null;
		try {
			Person p = em.createNamedQuery("findUserDetailsByUsername", Person.class)
					.setParameter("username", username).getSingleResult();
			Hibernate.initialize(p.getAuthorities());
			user = new User(p.getUsername(), p.getPassword(), true, true, true, true, p.getAuthorities());
		} catch (NoResultException nre) {
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IPersonDao#findPersonByUsername(java.lang.String)
	 */
	@Override
	public Person findPersonByUsername(String username) {
		return em.createNamedQuery("findPersonByUsername", Person.class).setParameter("username", username)
				.getSingleResult();
	}
}
