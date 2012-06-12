package com.ebi.formation.mfb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ebi.formation.mfb.dao.IRoleDao;
import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;

/**
 * Implémentation de l'interface IRoleDao
 * 
 * @author fguillain
 * 
 */
@Repository
public class RoleDao implements IRoleDao {

	private final Logger logger = LoggerFactory.getLogger(RoleDao.class);
	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IRoleDao#findRoleByRight(com.ebi.formation.mfb.entities.Role.Right)
	 */
	@Override
	public Role findRoleByRight(Right right) {
		logger.debug("findRoleByRight(right:{})", right);
		return em.createNamedQuery("findRoleByRight", Role.class).setParameter("right", right).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.dao.IRoleDao#findAllRights()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Right> findAllRights() {
		logger.debug("findAllRights()");
		return em.createNamedQuery("findAllRights").getResultList();
	}
}
