package com.ebi.formation.mfb.services.batch.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.formation.mfb.servicesapi.IOperationService;

/**
 * Classe qui sert à mettre à jour les opérations via un bach
 * 
 * @author excilys
 * 
 */
@Service
public class OperationServiceBatch {

	private final Logger logger = LoggerFactory.getLogger(OperationServiceBatch.class);
	@Autowired
	private IOperationService operationService;

	/**
	 * Méthode qui est exécutée par le batch
	 */
	public void doIt() {
		logger.debug("doIt()");
		operationService.updateCompteWithNewOperations();
	}
}
