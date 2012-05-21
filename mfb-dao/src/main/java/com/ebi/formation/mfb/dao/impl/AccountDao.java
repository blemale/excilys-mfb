package com.ebi.formation.mfb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IAccountDao;
import com.ebi.formation.mfb.entities.Person;

@Repository
public class AccountDao implements IAccountDao {

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
	 * @see com.ebi.formation.mfb.dao.IAccountDao#findOnwersByAccountId(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findOwnersByAccountId(Long id) {
		List<Person> persons;
		persons = em.createNamedQuery("findOnwersByAccountId").setParameter("id", id).getResultList();
		return persons;
	}
}
