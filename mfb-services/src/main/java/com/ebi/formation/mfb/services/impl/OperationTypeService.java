package com.ebi.formation.mfb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IOperationTypeDao;
import com.ebi.formation.mfb.entities.OperationType.Type;
import com.ebi.formation.mfb.servicesapi.IOperationTypeService;

/**
 * @author excilys
 * 
 */
@Service
@Transactional(readOnly = true)
public class OperationTypeService implements IOperationTypeService {

	@Autowired
	private IOperationTypeDao operationTypeDao;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationTypeService#findAllOperationTypes()
	 */
	@Override
	public List<Type> findAllOperationTypes() {
		return operationTypeDao.findAllOperationTypes();
	}
}
