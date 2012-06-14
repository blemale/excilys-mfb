package com.ebi.formation.mfb.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IRoleDao;
import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.servicesapi.IRoleService;

/**
 * @author excilys
 * 
 */
@Service
@Transactional(readOnly = true)
public class RoleService implements IRoleService {

	private final Logger logger = LoggerFactory.getLogger(RoleService.class);
	@Autowired
	private IRoleDao roleDao;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IRoleService#findRoleByRight(com.ebi.formation.mfb.entities.Role.Right)
	 */
	@Override
	public Role findRoleByRight(Right right) {
		logger.debug("findRoleByRight(right:{})", right);
		return roleDao.findRoleByRight(right);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IRoleService#findAllRights()
	 */
	@Override
	public List<Right> findAllRights() {
		logger.debug("findAllRights()");
		return roleDao.findAllRights();
	}
}
