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

	public static final int NUMBER_OF_OPERATIONS_BY_PAGE = 20;
	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#getTotalOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public BigDecimal findTotalOperationsCarteByMonth(long idCompte, int month, int year) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois;
		if (month == 12) {
			datePlusUnMois = new DateTime(year + 1, 1, 1, 0, 0);
		} else {
			datePlusUnMois = new DateTime(year, month + 1, 1, 0, 0);
		}
		return (BigDecimal) em.createNamedQuery("findTotalOperationsCarteByMonth").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setParameter("type", OperationType.Type.CARTE).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#getTotalOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public long findNumbreOfOperationsCarteByMonth(long idCompte, int month, int year) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois;
		if (month == 12) {
			datePlusUnMois = new DateTime(year + 1, 1, 1, 0, 0);
		} else {
			datePlusUnMois = new DateTime(year, month + 1, 1, 0, 0);
		}
		return (Long) em.createNamedQuery("findNumberOfOperationsCarteByMonth").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setParameter("type", OperationType.Type.CARTE).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#getOperationsWithoutCarteByMonthPaginated(long, int, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> findOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois;
		if (month == 12) {
			datePlusUnMois = new DateTime(year + 1, 1, 1, 0, 0);
		} else {
			datePlusUnMois = new DateTime(year, month + 1, 1, 0, 0);
		}
		System.out.println(date.toString());
		System.out.println(datePlusUnMois.toString());
		return em.createNamedQuery("findOperationsWithoutCarteByMonthPaginated").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setFirstResult(offset * NUMBER_OF_OPERATIONS_BY_PAGE)
				.setMaxResults((offset + 1) * NUMBER_OF_OPERATIONS_BY_PAGE).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationDao#getOperationsCarteByMonthPaginated(long, int, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> findOperationsCarteByMonthPaginated(long idCompte, int month, int year, int offset) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois;
		if (month == 12) {
			datePlusUnMois = new DateTime(year + 1, 1, 1, 0, 0);
		} else {
			datePlusUnMois = new DateTime(year, month + 1, 1, 0, 0);
		}
		return em.createNamedQuery("findOperationsCarteByMonthPaginated").setParameter("idcompte", idCompte)
				.setParameter("dateEffet", date).setParameter("datePlusUnMois", datePlusUnMois)
				.setFirstResult(offset * NUMBER_OF_OPERATIONS_BY_PAGE)
				.setMaxResults((offset + 1) * NUMBER_OF_OPERATIONS_BY_PAGE).getResultList();
	}
}