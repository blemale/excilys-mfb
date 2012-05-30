package com.ebi.formation.mfb.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.entities.OperationType;

/**
 * Implémentation de l'interface IOperationDao
 * 
 * @author kpogorzelski
 * @author tbakir
 * 
 */
/**
 * @author excilys
 * 
 */
@Repository
public class OperationDao implements IOperationDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findTotalOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public BigDecimal findTotalOperationsCarteByMonth(long idCompte, DateTime date, DateTime datePlusUnMois) {
		return (BigDecimal) em.createNamedQuery("findTotalOperationsCarteByMonth").setParameter("idcompte", idCompte)
				.setParameter("dateValeur", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setParameter("type", OperationType.Type.CARTE).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findNumbreOfOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public long findNumberOfOperationsCarteByMonth(long idCompte, DateTime date, DateTime datePlusUnMois) {
		return (Long) em.createNamedQuery("findNumberOfOperationsByTypeByMonth").setParameter("idcompte", idCompte)
				.setParameter("dateValeur", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setParameter("type", OperationType.Type.CARTE).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findOperationsWithoutCarteByMonthPaginated(long, int, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> findOperationsWithoutCarteByMonthPaginated(long idCompte, DateTime date,
			DateTime datePlusUnMois, int offset, int numberOfResults) {
		return em.createNamedQuery("findOperationsWithoutCarteByMonthPaginated").setParameter("idcompte", idCompte)
				.setParameter("dateValeur", date).setParameter("datePlusUnMois", datePlusUnMois).setFirstResult(offset)
				.setMaxResults(offset + numberOfResults).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findOperationsCarteByMonthPaginated(long, int, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> findOperationsCarteByMonthPaginated(long idCompte, DateTime date, DateTime datePlusUnMois,
			int offset, int numberOfResults) {
		return em.createNamedQuery("findOperationsCarteByMonthPaginated").setParameter("idcompte", idCompte)
				.setParameter("dateValeur", date).setParameter("datePlusUnMois", datePlusUnMois).setFirstResult(offset)
				.setMaxResults(offset + numberOfResults).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findNumberOfOperationsWithoutCarteByMonth(long,
	 * org.joda.time.DateTime, org.joda.time.DateTime)
	 */
	@Override
	public long findNumberOfOperationsWithoutCarteByMonth(long idCompte, DateTime date, DateTime datePlusUnMois) {
		return (Long) em.createNamedQuery("findNumberOfOperationsWithoutTypeByMonth")
				.setParameter("idcompte", idCompte).setParameter("dateValeur", date)
				.setParameter("datePlusUnMois", datePlusUnMois).setParameter("type", OperationType.Type.CARTE)
				.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#updateCompteQuotidient()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void updateCompteQuotidient() {
		DateTime today = new DateTime();
		List<Operation> l = em.createNamedQuery("findOperationsBeforeDate").setParameter("today", today)
				.getResultList();
		// TODO : Modifier la requête quand il y aura les flags dans les opérations.
		for (Operation o : l) {
			em.createNamedQuery("updateCompteWithValue").setParameter("valeur", o.getMontant())
					.setParameter("operation", o.getCompte()).executeUpdate();
		}
	}
}