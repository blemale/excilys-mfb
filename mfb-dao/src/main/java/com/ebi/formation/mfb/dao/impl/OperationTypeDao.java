package com.ebi.formation.mfb.dao.impl;

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

	@Override
	public OperationType getOperationTypeByType(Type type) {
		return (OperationType) em.createNamedQuery("findOperationTypeByType").setParameter("type", type)
				.getSingleResult();
	}
}
