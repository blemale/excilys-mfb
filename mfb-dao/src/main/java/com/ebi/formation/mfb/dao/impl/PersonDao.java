package com.ebi.formation.mfb.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.entities.Role;

/**
 * Implémentation de IPersonDAO, via JPA.
 * 
 * @author excilys
 * 
 */
@Repository
public class PersonDao implements IPersonDao {

	private final Logger logger = LoggerFactory.getLogger(PersonDao.class);
	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IPersonDao#findUserDetailsByUsername(java.lang.String)
	 */
	@Override
	public UserDetails findUserDetailsByUsername(String username) {
		logger.debug("findUserDetailsByUsername(username:{})", username);
		UserDetails user = null;
		try {
			Person p = em.createNamedQuery("findUserDetailsByUsername", Person.class)
					.setParameter("username", username).getSingleResult();
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (Role role : p.getAuthorities()) {
				authorities.add(new SimpleGrantedAuthority(role.getRight().name()));
			}
			user = new User(p.getUsername(), p.getPassword(), true, true, true, true, authorities);
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
		logger.debug("findPersonByUsername(username:{})", username);
		return em.createNamedQuery("findPersonByUsername", Person.class).setParameter("username", username)
				.getSingleResult();
	}
}
