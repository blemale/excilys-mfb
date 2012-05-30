package com.ebi.formation.mfb.dao.impl;

import java.math.BigDecimal;
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
		long result = 0;
		try {
			result = em.createNamedQuery("checkCompteOwnershipByUsernameAndCompteId", Long.class)
					.setParameter("username", username).setParameter("compteId", compteId).getSingleResult();
		} catch (NoResultException nre) {
			return false;
		}
		return result == 0L ? false : true;
	}

	@Override
	public Compte findCompteById(long id) {
		Compte c = null;
		try {
			return em.createNamedQuery("findCompteById", Compte.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException nre) {
			// TODO logger pour l'ecxeption
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.ICompteDao#findMontantCompteById(java.lang.Long)
	 */
	@Override
	public BigDecimal findMontantCompteById(Long id) {
		return (BigDecimal) em.createNamedQuery("findSoldeCompte").setParameter("id", id).getSingleResult();
	}
}
