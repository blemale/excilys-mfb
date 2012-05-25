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
@Repository
public class OperationDao implements IOperationDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findTotalOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public BigDecimal findTotalOperationsCarteByMonth(long idCompte, int month, int year) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return (BigDecimal) em.createNamedQuery("findTotalOperationsCarteByMonth").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setParameter("type", OperationType.Type.CARTE).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findNumbreOfOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public long findNumbreOfOperationsCarteByMonth(long idCompte, int month, int year) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return (Long) em.createNamedQuery("findNumberOfOperationsByTypeByMonth").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setParameter("type", OperationType.Type.CARTE).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findOperationsWithoutCarteByMonthPaginated(long, int, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> findOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return em.createNamedQuery("findOperationsWithoutCarteByMonthPaginated").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois).setFirstResult(offset)
				.setMaxResults(offset + numberOfResults).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#findOperationsCarteByMonthPaginated(long, int, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> findOperationsCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return em.createNamedQuery("findOperationsCarteByMonthPaginated").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois).setFirstResult(offset)
				.setMaxResults(offset + numberOfResults).getResultList();
	}

	@Override
	public long findNumbreOfOperationsWhithoutCarteByMonth(long idCompte, int month, int year) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return (Long) em.createNamedQuery("findNumberOfOperationsWithoutTypeByMonth")
				.setParameter("idcompte", idCompte).setParameter("dateEffet", date)
				.setParameter("datePlusUnMois", datePlusUnMois).setParameter("type", OperationType.Type.CARTE)
				.getSingleResult();
	}
}