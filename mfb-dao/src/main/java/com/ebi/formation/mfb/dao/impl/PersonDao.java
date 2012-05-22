package com.ebi.formation.mfb.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IPersonDao;

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
			user = (UserDetails) em.createNamedQuery("findUserDetailsByUsername").setParameter("username", username)
					.getSingleResult();
			Hibernate.initialize(user.getAuthorities());
		} catch (NoResultException nre) {
		}
		return user;
	}
}
