package com.ebi.formation.mfb.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.dao.IOperationTypeDao;
import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.entities.OperationType;
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
	 * int)
	 */
	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		logger.debug("getOperationsWithoutCarteByMonthPaginated(idCompte:{}, month:{}, year:{}, page:{})",
				new Object[] { idCompte, month, year, page });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findOperationsWithoutCarteByMonthPaginated(idCompte, date, datePlusUnMois, page
				* NB_RESULT_BY_DEFAULT, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getOperationsCarteByMonthPaginated(long, int, int, int)
	 */
	@Override
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		logger.debug("getOperationsCarteByMonthPaginated(idCompte:{}, month:{}, year:{}, page:{})", new Object[] {
				idCompte, month, year, page });
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findOperationsCarteByMonthPaginated(idCompte, date, datePlusUnMois, page
				* NB_RESULT_BY_DEFAULT, NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForOperationsWithoutCartesByMonth(long,
	 * int, int)
	 */
	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year) {
		int extraPageIfNeeded = getNumberOfOperationsWithoutCarteByMonth(idCompte, month, year) % NB_RESULT_BY_DEFAULT == 0 ? 0
				: 1;
		return (getNumberOfOperationsWithoutCarteByMonth(idCompte, month, year) / NB_RESULT_BY_DEFAULT)
				+ extraPageIfNeeded;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForOperationsCartesByMonth(long, int, int)
	 */
	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int year) {
		int extraPageIfNeeded = getNumberOfOperationsCarteByMonth(idCompte, month, year) % NB_RESULT_BY_DEFAULT == 0 ? 0
				: 1;
		return (getNumberOfOperationsCarteByMonth(idCompte, month, year) / NB_RESULT_BY_DEFAULT) + extraPageIfNeeded;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getVirementsByMonthPaginated(long, int, int, int)
	 */
	@Override
	public List<Operation> getVirementsByMonthPaginated(long idCompte, int month, int year, int page) {
		DateTime date = new DateTime(year, month, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		return operationDao.findVirementsByMonthPaginated(idCompte, date, datePlusUnMois, page * NB_RESULT_BY_DEFAULT,
				NB_RESULT_BY_DEFAULT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#getNumberOfPagesForVirementByMonth(java.lang.String, int,
	 * int)
	 */
	@Override
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int year) {
		int extraPageIfNeeded = getNumberOfVirementByMonth(idCompte, month, year) % NB_RESULT_BY_DEFAULT == 0 ? 0 : 1;
		return (getNumberOfVirementByMonth(idCompte, month, year) / NB_RESULT_BY_DEFAULT) + extraPageIfNeeded;
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
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public ReturnCodeVirement doVirement(long idCompteADebiter, long idCompteACrediter, String label,
			BigDecimal montant, DateTime dateEffet, DateTime dateValeur) {
		logger.debug(
				"doVirement(idCompteADebiter:{}, idCompteACrediter:{}, label:{}, montant:{}, dateEffet:{}, dateValeur:{})",
				new Object[] { idCompteADebiter, idCompteACrediter, label, montant, dateEffet, dateValeur });
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
		Operation credit = new Operation();
		// operation immediate
		if (dateValeur.isBeforeNow() || dateValeur.equals(new DateTime())) {
			BigDecimal newSoldeDebit = compteADebiter.getSolde().add(montant.negate());
			BigDecimal newSoldeCredit = compteACrediter.getSolde().add(montant);
			compteADebiter.setSolde(newSoldeDebit);
			compteACrediter.setSolde(newSoldeCredit);
			BigDecimal newSoldePreviDebit = compteADebiter.getSoldePrevisionnel().add(montant.negate());
			BigDecimal newSoldePrevisCredit = compteACrediter.getSoldePrevisionnel().add(montant);
			compteADebiter.setSoldePrevisionnel(newSoldePreviDebit);
			compteACrediter.setSoldePrevisionnel(newSoldePrevisCredit);
			// compteDao.updateCompteSoldeAndSoldePrevisionnel(idCompteACrediter, montant);
			// compteDao.updateCompteSoldeAndSoldePrevisionnel(idCompteADebiter, montant.negate());
			debit.setOperationDone(Boolean.TRUE);
			credit.setOperationDone(Boolean.TRUE);
		}
		// operation en prévision
		else {
			BigDecimal newSoldePreviDebit = compteADebiter.getSoldePrevisionnel().add(montant.negate());
			BigDecimal newSoldePrevisCredit = compteACrediter.getSoldePrevisionnel().add(montant);
			compteADebiter.setSoldePrevisionnel(newSoldePreviDebit);
			compteACrediter.setSoldePrevisionnel(newSoldePrevisCredit);
			// compteDao.updateCompteSoldePrevisionnel(idCompteACrediter, montant);
			// compteDao.updateCompteSoldePrevisionnel(idCompteADebiter, montant.negate());
			debit.setOperationDone(Boolean.FALSE);
			credit.setOperationDone(Boolean.FALSE);
		}
		// operation debit
		debit.setCompte(compteADebiter);
		debit.setDateEffet(dateEffet);
		debit.setDateValeur(dateValeur);
		debit.setLabel(labelDebit);
		debit.setMontant(montant.negate());
		debit.setType(operationTypeDao.getOperationTypeByType(Type.VIREMENT));
		// operation credit
		credit.setCompte(compteACrediter);
		credit.setDateEffet(dateEffet);
		credit.setDateValeur(dateValeur);
		credit.setLabel(labelCredit);
		credit.setMontant(montant);
		credit.setType(operationTypeDao.getOperationTypeByType(Type.VIREMENT));
		operationDao.save(debit);
		operationDao.save(credit);
		return ReturnCodeVirement.OK;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#doVirement(long, java.lang.String, java.lang.String,
	 * java.math.BigDecimal)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public ReturnCodeVirement doVirement(long idCompteADebiter, String numeroCompteACrediter, String label,
			BigDecimal montant, DateTime dateEffet, DateTime dateValeur) {
		logger.debug(
				"doVirement(idCompteADebiter:{}, numeroCompteACrediter:{}, label:{}, montant:{}, dateEffet:{}, dateValeur:{})",
				new Object[] { idCompteADebiter, numeroCompteACrediter, label, montant, dateEffet, dateValeur });
		Compte compteACrediter = compteDao.findCompteByNumeroCompte(numeroCompteACrediter);
		if (compteACrediter == null) {
			return ReturnCodeVirement.COMPTE_CREDIT_INEXISTANT;
		}
		return doVirement(idCompteADebiter, compteACrediter.getId(), label, montant, dateEffet, dateValeur);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#updateCompteWithNewOperations()
	 */
	@Override
	public void updateCompteWithNewOperations() {
		logger.debug("updateCompteWithNewOperations()");
		operationDao.updateCompteWithNewOperations();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.services.IOperationService#saveOperation(java.math.BigDecimal, java.lang.Long,
	 * com.ebi.formation.mfb.entities.OperationType.Type, java.lang.String, org.joda.time.DateTime,
	 * org.joda.time.DateTime)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public ReturnCodeOperation saveOperation(BigDecimal montant, Long idCompte, Type type, String label,
			DateTime dateEffet, DateTime dateValeur) {
		logger.debug("saveOperation(montant:{}, idCompte:{}, type:{}, label:{}, dateEffet:{}, dateValeur:{})",
				new Object[] { montant, idCompte, type, label, dateEffet, dateValeur });
		Compte c = compteDao.findCompteById(idCompte);
		if (c == null) {
			return ReturnCodeOperation.COMPTE_INEXISTANT;
		}
		OperationType ot = operationTypeDao.getOperationTypeByType(type);
		Operation o = new Operation();
		o.setCompte(c);
		o.setDateEffet(dateEffet);
		o.setDateValeur(dateValeur);
		o.setLabel(label);
		o.setMontant(montant);
		o.setType(ot);
		// operation immediate
		if (dateValeur.isBeforeNow() || dateValeur.equals(new DateTime())) {
			// BigDecimal newSolde = c.getSolde().add(montant);
			// c.setSolde(newSolde);
			compteDao.updateCompteSoldeAndSoldePrevisionnel(idCompte, montant);
			o.setOperationDone(Boolean.TRUE);
		}
		// operation en prévision
		else {
			if (Type.CARTE.equals(type)) {
				// BigDecimal newEncoursCarte = c.getEncoursCarte().add(montant);
				// c.setEncoursCarte(newEncoursCarte);
				compteDao.updateCompteEncoursCarteAndSoldePrevisionnel(idCompte, montant);
			} else {
				compteDao.updateCompteSoldePrevisionnel(idCompte, montant);
			}
			o.setOperationDone(Boolean.FALSE);
		}
		// dans tous les cas...
		// BigDecimal newSoldePrevi = c.getSoldePrevisionnel().add(montant);
		// c.setSoldePrevisionnel(newSoldePrevi);
		operationDao.save(o);
		return ReturnCodeOperation.OK;
	}

	@Override
	public List<Operation> getLastOperationByCompte(long idCompte, int numberOfOperations) {
		return operationDao.findLastOperationByCompte(idCompte, numberOfOperations);
	}
}
