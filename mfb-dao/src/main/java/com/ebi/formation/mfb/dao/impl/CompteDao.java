package com.ebi.formation.mfb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.entities.Compte;

/**
 * Implémentation de l'interface ICompteDao
 * 
 * @author excilys
 * 
 */
@Repository
public class CompteDao implements ICompteDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findComptesByUsername(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> findComptesByUsername(String username) {
		return em.createNamedQuery("findComptesByUsername").setParameter("username", username).getResultList();
	}

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		try {
			em.createNamedQuery("checkCompteOwnershipByUsernameAndCompteId", Compte.class)
					.setParameter("username", username).setParameter("compteId", compteId).getSingleResult();
		} catch (NoResultException nre) {
			return false;
		}
		return true;
	}
}
