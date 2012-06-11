package com.ebi.formation.mfb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IOperationTypeDao;
import com.ebi.formation.mfb.entities.OperationType;
import com.ebi.formation.mfb.entities.OperationType.Type;

@Repository
public class OperationTypeDao implements IOperationTypeDao {

	private final Logger logger = LoggerFactory.getLogger(OperationTypeDao.class);
	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.dao.IOperationTypeDao#getOperationTypeByType(com.ebi.formation.mfb.entities.OperationType
	 * .Type)
	 */
	@Override
	public OperationType getOperationTypeByType(Type type) {
		logger.debug("getOperationTypeByType(type:{})", type);
		return (OperationType) em.createNamedQuery("findOperationTypeByType").setParameter("type", type)
				.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IOperationTypeDao#findAllOperationTypes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Type> findAllOperationTypes() {
		return em.createNamedQuery("findAllOperationTypes").getResultList();
	}
}
