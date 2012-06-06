package com.ebi.formation.mfb.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.dao.IOperationTypeDao;
import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.entities.OperationType.Type;
import com.ebi.formation.mfb.services.IOperationService;

@Service
@Transactional(readOnly = true)
public class OperationService implements IOperationService {

	private final Logger logger = LoggerFactory.getLogger(OperationService.class);
	public static final int NB_RESULT_BY_DEFAULT = 20;
	@Autowired
	private IOperationDao operationDao;
	@Autowired
	private ICompteDao compteDao;
	@Autowired
	private IOperationTypeDao operationTypeDao;

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
	public List<Operation> getVirementsByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findVirementsByMonthPaginated(idCompte, date, datePlusUnMois, offset, numberOfResults);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getVirementsByMonthPaginated(long, int, int, int)
	 */
	@Override
	public List<Operation> getVirementsByMonthPaginated(long idCompte, int month, int year, int page) {
		return getVirementsByMonthPaginated(idCompte, month, year, page * NB_RESULT_BY_DEFAULT, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForVirementByMonth(java.lang.String, int,
	 * int)
	 */
	@Override
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int year) {
		return getNumberOfPagesForVirementByMonth(idCompte, month, year, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForVirementByMonth(java.lang.String, int,
	 * int, int)
	 */
	@Override
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int year, int numberOfResults) {
		int extraPageIfNeeded = getNumberOfVirementByMonth(idCompte, month, year) % numberOfResults == 0 ? 0 : 1;
		return (getNumberOfVirementByMonth(idCompte, month, year) / numberOfResults) + extraPageIfNeeded;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfVirementByMonth(java.lang.String, int, int)
	 */
	@Override
	public long getNumberOfVirementByMonth(long idCompte, int month, int year) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findNumberOfVirementsByMonth(idCompte, date, datePlusUnMois);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getAllOperationsByMonthByCompte(long, int, int)
	 */
	@Override
	public List<Operation> getAllOperationsByMonthByCompte(long idCompte, int month, int year) {
		logger.debug("getAllOperationsByMonthByCompte(idCompte:{}, month:{}, year:{})", new Object[] { idCompte, month,
				year });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findAllOperationsByMonthByCompte(idCompte, date, datePlusUnMois);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#doVirement(long, long, java.lang.String,
	 * java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public ReturnCodeVirement doVirement(long idCompteADebiter, long idCompteACrediter, String label, BigDecimal montant) {
		if (montant.signum() == -1 || montant.signum() == 0) {
			return ReturnCodeVirement.MONTANT_INCORRECT;
		}
		if (idCompteADebiter == idCompteACrediter) {
			return ReturnCodeVirement.IDENTICAL_COMPTES;
		}
		Compte compteADebiter = compteDao.findCompteById(idCompteADebiter);
		Compte compteACrediter = compteDao.findCompteById(idCompteACrediter);
		if (compteADebiter == null) {
			return ReturnCodeVirement.COMPTE_DEBIT_INEXISTANT;
		}
		if (compteACrediter == null) {
			return ReturnCodeVirement.COMPTE_CREDIT_INEXISTANT;
		}
		if (compteADebiter.getSolde().add(montant.negate()).signum() == -1) {
			return ReturnCodeVirement.DECOUVERT;
		}
		String labelDebit = label;
		String labelCredit = label;
		if (label == null) {
			labelDebit = "Virement à " + compteACrediter.getLabel();
			labelCredit = "Virement de " + compteADebiter.getLabel();
		}
		Operation debit = new Operation();
		debit.setCompte(compteADebiter);
		DateTime now = DateTime.now();
		debit.setDateEffet(now);
		debit.setDateValeur(now);
		debit.setLabel(labelDebit);
		debit.setMontant(montant.negate());
		debit.setType(operationTypeDao.getOperationTypeByType(Type.VIREMENT));
		debit.setOperationDone(Boolean.TRUE);
		Operation credit = new Operation();
		credit.setCompte(compteACrediter);
		credit.setDateEffet(now);
		credit.setDateValeur(now);
		credit.setLabel(labelCredit);
		credit.setMontant(montant);
		credit.setType(operationTypeDao.getOperationTypeByType(Type.VIREMENT));
		credit.setOperationDone(Boolean.TRUE);
		operationDao.save(debit);
		operationDao.save(credit);
		// TODO demander à Stéphane pour l'isolation des données
		BigDecimal newSoldeDebit = compteADebiter.getSolde().add(montant.negate());
		BigDecimal newSoldeCredit = compteACrediter.getSolde().add(montant);
		compteADebiter.setSolde(newSoldeDebit);
		compteACrediter.setSolde(newSoldeCredit);
		return ReturnCodeVirement.OK;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#doVirement(long, java.lang.String, java.lang.String,
	 * java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public ReturnCodeVirement doVirement(long idCompteADebiter, String numeroCompteACrediter, String label,
			BigDecimal montant) {
		Compte compteACrediter = compteDao.findCompteByNumeroCompte(numeroCompteACrediter);
		if (compteACrediter == null) {
			return ReturnCodeVirement.COMPTE_CREDIT_INEXISTANT;
		}
		return doVirement(idCompteADebiter, compteACrediter.getId(), label, montant);
	}
}
