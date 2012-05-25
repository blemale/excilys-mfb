package com.ebi.formation.mfb.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.IOperationService;

public class OperationService implements IOperationService {

	public static final int NB_RESULT_BY_DEFAULT = 20;
	@Autowired
	private IOperationDao operationDao;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getTotalOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public BigDecimal getTotalOperationsCarteByMonth(long idCompte, int month, int year) {
		BigDecimal result = null;
		if (operationDao.findNumberOfOperationsCarteByMonth(idCompte, month, year) != 0) {
			result = operationDao.findTotalOperationsCarteByMonth(idCompte, month, year);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumbreOfOperationsCarteByMonth(long, int, int)
	 */
	@Override
	public long getNumberOfOperationsCarteByMonth(long idCompte, int month, int year) {
		return operationDao.findNumberOfOperationsCarteByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumbreOfOperationsWhithoutCarteByMonth(long, int, int)
	 */
	@Override
	public long getNumberOfOperationsWithoutCarteByMonth(long idCompte, int month, int year) {
		return operationDao.findNumberOfOperationsWithoutCarteByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsWithoutCarteByMonthPaginated(long, int, int,
	 * int, int)
	 */
	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		return operationDao.findOperationsWithoutCarteByMonthPaginated(idCompte, month, year, offset, numberOfResults);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsWithoutCarteByMonthPaginated(long, int, int,
	 * int)
	 */
	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int page) {
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
		return operationDao.findOperationsCarteByMonthPaginated(idCompte, month, year, offset, numberOfResults);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsCarteByMonthPaginated(long, int, int, int)
	 */
	@Override
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page) {
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
}
