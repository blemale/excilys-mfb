package com.ebi.formation.mfb.services.impl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.services.IOperationServiceBatch;

/**
 * @author fguillain
 * 
 */
public class OperationServiceBatch extends QuartzJobBean implements IOperationServiceBatch {

	private final Logger logger = LoggerFactory.getLogger(OperationServiceBatch.class);
	private IOperationDao operationDao;

	/**
	 * @param operationDao
	 */
	public void setOperationDao(IOperationDao operationDao) {
		this.operationDao = operationDao;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		this.updateCompte();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationServiceBatch#updateCompte()
	 */
	@Override
	public void updateCompte() {
		logger.debug("updateCompte()");
		operationDao.updateCompte();
	}
}
