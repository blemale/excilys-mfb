package com.ebi.formation.mfb.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;

@Repository
@Transactional(readOnly = true)
public class PersonDao implements IPersonDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public UserDetails findUserDetailsByUsername(String username) {
		UserDetails user;
		try {
			user = (UserDetails) em.createNamedQuery("findUserDetailsByUsername").setParameter("username", username)
					.getSingleResult();
			Hibernate.initialize(user.getAuthorities());
		} catch (NoResultException nre) {
			user = null;
		}
		return user;
	}
}
