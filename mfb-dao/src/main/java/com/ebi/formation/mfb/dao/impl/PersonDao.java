package com.ebi.formation.mfb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Compte;

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

	/**
	 * Met à jour l'EntityManager à utiliser pour ce DAO.
	 * 
	 * @param em
	 *            l'EntityManager à utiliser
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IPersonDao#findUserDetailsByUsername(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IPersonDao#findComptesByUsername(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<Compte> findComptesByUsername(String username) {
		List<Compte> comptes;
		comptes = em.createNamedQuery("findComptesByUsername").setParameter("username", username).getResultList();
		return comptes;
	}
}
