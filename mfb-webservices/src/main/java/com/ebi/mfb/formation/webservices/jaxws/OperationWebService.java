package com.ebi.mfb.formation.webservices.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.IOperationService;

@WebService
public class OperationWebService implements IOperationService {

	@Autowired
	private IOperationService operationService;

	@Override
	public BigDecimal getTotalOperationsCarteByMonth(long idCompte, int month, int year) {
		return operationService.getTotalOperationsCarteByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfOperationsCarteByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfOperationsCarteByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfOperationsWithoutCarteByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfOperationsWithoutCarteByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfVirementByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfVirementByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getOperationsWithoutCarteByMonthPaginatedCustom")
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		return operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, offset,
				numberOfResults);
	}

	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		return operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, page);
	}

	@Override
	@WebMethod(operationName = "getOperationsCarteByMonthPaginatedCustom")
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		return operationService.getOperationsCarteByMonthPaginated(idCompte, month, year, offset, numberOfResults);
	}

	@Override
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		return operationService.getOperationsCarteByMonthPaginated(idCompte, month, year, page);
	}

	@Override
	@WebMethod(operationName = "getVirementsByMonthPaginatedCustom")
	public List<Operation> getVirementsByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		return operationService.getVirementsByMonthPaginated(idCompte, month, year, offset, numberOfResults);
	}

	@Override
	public List<Operation> getVirementsByMonthPaginated(long idCompte, int month, int year, int page) {
		return operationService.getVirementsByMonthPaginated(idCompte, month, year, page);
	}

	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getNumberOfPagesForOperationsWithoutCartesByMonthCustom")
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year,
			int numberOfResults) {
		return operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year,
				numberOfResults);
	}

	@Override
	@WebMethod(operationName = "")
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getNumberOfPagesForOperationsCartesByMonthCustom")
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int years, int numberOfResults) {
		return operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, years, numberOfResults);
	}

	@Override
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForVirementByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getNumberOfPagesForVirementByMonthCustom")
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int years, int numberOfResults) {
		return operationService.getNumberOfPagesForVirementByMonth(idCompte, month, years, numberOfResults);
	}

	@Override
	public List<Operation> getAllOperationsByMonthByCompte(long idCompte, int month, int year) {
		return operationService.getAllOperationsByMonthByCompte(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "doVirementInterne")
	public ReturnCodeVirement doVirement(long idCompteADebiter, long idCompteACrediter, String label, BigDecimal montant) {
		return operationService.doVirement(idCompteADebiter, idCompteACrediter, label, montant);
	}

	@Override
	@WebMethod(operationName = "doVirementExterne")
	public ReturnCodeVirement doVirement(long idCompteADebiter, String numeroCompteACrediter, String label,
			BigDecimal montant) {
		return operationService.doVirement(idCompteADebiter, numeroCompteACrediter, label, montant);
	}
}