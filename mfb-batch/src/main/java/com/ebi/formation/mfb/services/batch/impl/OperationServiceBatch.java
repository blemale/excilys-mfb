package com.ebi.formation.mfb.services.batch.impl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ebi.formation.mfb.services.IOperationService;

/**
 * @author fguillain
 * 
 */
public class OperationServiceBatch extends QuartzJobBean {

	private final Logger logger = LoggerFactory.getLogger(OperationServiceBatch.class);
	@Autowired
	private IOperationService operationService;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.debug("executeInternal()");
		operationService.updateCompteWithNewOperations();
	}
}
