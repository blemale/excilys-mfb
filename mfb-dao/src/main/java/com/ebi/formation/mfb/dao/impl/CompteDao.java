package com.ebi.formation.mfb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.entities.Person;

/**
 * Implémentation de l'interface ICompteDao
 * 
 * @author excilys
 * 
 */
@Repository
@Transactional(readOnly = true)
public class CompteDao implements ICompteDao {

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
	public List<Person> findOwnersByCompteId(Long id) {
		List<Person> persons;
		persons = em.createNamedQuery("findOwnersByAccountId").setParameter("id", id).getResultList();
		return persons;
	}
}
