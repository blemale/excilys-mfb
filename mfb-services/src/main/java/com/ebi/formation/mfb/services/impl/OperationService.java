package com.ebi.formation.mfb.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.IOperationService;

@Service
@Transactional(readOnly = true)
public class OperationService implements IOperationService {

	private final Logger logger = LoggerFactory.getLogger(OperationService.class);
	public static final int NB_RESULT_BY_DEFAULT = 20;
	@Autowired
	private IOperationDao operationDao;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getTotalOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public BigDecimal getTotalOperationsCarteByMonth(long idCompte, int month, int year) {
		logger.debug("getTotalOperationsCarteByMonth(idCompte:{}, month:{}, year:{})", new Object[] { idCompte, month,
				year });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		BigDecimal result = null;
		if (operationDao.findNumberOfOperationsCarteByMonth(idCompte, date, datePlusUnMois) != 0) {
			result = operationDao.findTotalOperationsCarteByMonth(idCompte, date, datePlusUnMois);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumbreOfOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public long getNumberOfOperationsCarteByMonth(long idCompte, int month, int year) {
		logger.debug("getNumberOfOperationsCarteByMonth(idCompte:{}, month:{}, year:{})", new Object[] { idCompte,
				month, year });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findNumberOfOperationsCarteByMonth(idCompte, date, datePlusUnMois);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumbreOfOperationsWhithoutCarteByMonth(long, int, int)
	 */
	@Override
	public long getNumberOfOperationsWithoutCarteByMonth(long idCompte, int month, int year) {
		logger.debug("getNumberOfOperationsWithoutCarteByMonth(idCompte:{}, month:{}, year:{})", new Object[] {
				idCompte, month, year });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findNumberOfOperationsWithoutCarteByMonth(idCompte, date, datePlusUnMois);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsWithoutCarteByMonthPaginated(long, int, int,
	 * int, int)
	 */
	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		logger.debug(
				"getOperationsWithoutCarteByMonthPaginated(idCompte:{}, month:{}, year:{}, offset:{}, numberOfResults:{})",
				new Object[] { idCompte, month, year, offset, numberOfResults });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findOperationsWithoutCarteByMonthPaginated(idCompte, date, datePlusUnMois, offset,
				numberOfResults);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsWithoutCarteByMonthPaginated(long, int, int,
	 * int)
	 */
	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		logger.debug("getOperationsWithoutCarteByMonthPaginated(idCompte:{}, month:{}, year:{}, page:{})",
				new Object[] { idCompte, month, year, page });
		return getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, page * NB_RESULT_BY_DEFAULT,
				NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsCarteByMonthPaginated(long, int, int, int,
	 * int)
	 */
	@Override
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		logger.debug(
				"getOperationsCarteByMonthPaginated(idCompte:{}, month:{}, year:{}, offset:{}, numberOfResults:{})",
				new Object[] { idCompte, month, year, offset, numberOfResults });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao
				.findOperationsCarteByMonthPaginated(idCompte, date, datePlusUnMois, offset, numberOfResults);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsCarteByMonthPaginated(long, int, int, int)
	 */
	@Override
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		logger.debug("getOperationsCarteByMonthPaginated(idCompte:{}, month:{}, year:{}, page:{})", new Object[] {
				idCompte, month, year, page });
		return getOperationsCarteByMonthPaginated(idCompte, month, year, page * NB_RESULT_BY_DEFAULT,
				NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForOperationsWithoutCartesByMonth(long,
	 * int, int)
	 */
	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year) {
		return getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForOperationsWithoutCartesByMonth(long,
	 * int, int, int)
	 */
	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year,
			int numberOfResults) {
		int extraPageIfNeeded = getNumberOfOperationsWithoutCarteByMonth(idCompte, month, year) % numberOfResults == 0 ? 0
				: 1;
		return (getNumberOfOperationsWithoutCarteByMonth(idCompte, month, year) / numberOfResults) + extraPageIfNeeded;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForOperationsCartesByMonth(long, int, int)
	 */
	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int year) {
		return getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForOperationsCartesByMonth(long, int, int,
	 * int)
	 */
	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int year, int numberOfResults) {
		int extraPageIfNeeded = getNumberOfOperationsCarteByMonth(idCompte, month, year) % numberOfResults == 0 ? 0 : 1;
		return (getNumberOfOperationsCarteByMonth(idCompte, month, year) / numberOfResults) + extraPageIfNeeded;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getVirementsByMonthPaginated(long, int, int, int, int)
	 */
	@Override
	public List<Operation> getVirementsByMonthPaginated(String username, int month, int year, int offset,
			int numberOfResults) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findVirementsByMonthPaginated(username, date, datePlusUnMois, offset, numberOfResults);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getVirementsByMonthPaginated(long, int, int, int)
	 */
	@Override
	public List<Operation> getVirementsByMonthPaginated(String username, int month, int year, int page) {
		return getVirementsByMonthPaginated(username, month, year, page * NB_RESULT_BY_DEFAULT, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForVirementByMonth(java.lang.String, int,
	 * int)
	 */
	@Override
	public long getNumberOfPagesForVirementByMonth(String username, int month, int year) {
		return getNumberOfPagesForVirementByMonth(username, month, year, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForVirementByMonth(java.lang.String, int,
	 * int, int)
	 */
	@Override
	public long getNumberOfPagesForVirementByMonth(String username, int month, int year, int numberOfResults) {
		int extraPageIfNeeded = getNumberOfVirementByMonth(username, month, year) % numberOfResults == 0 ? 0 : 1;
		return (getNumberOfVirementByMonth(username, month, year) / numberOfResults) + extraPageIfNeeded;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfVirementByMonth(java.lang.String, int, int)
	 */
	@Override
	public long getNumberOfVirementByMonth(String username, int month, int year) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findNumberOfVirementsByMonth(username, date, datePlusUnMois);
	}
}
