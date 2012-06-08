package com.ebi.formation.mfb.webservices.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.IOperationService;

@WebService
public class OperationWebService implements IOperationService {

	@Autowired
	private IOperationService operationService;

	@Override
	public BigDecimal getTotalOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getTotalOperationsCarteByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getNumberOfOperationsCarteByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfOperationsWithoutCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getNumberOfOperationsWithoutCarteByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getNumberOfVirementByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getOperationsWithoutCarteByMonthPaginatedCustom")
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults) {
		return operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, offset,
				numberOfResults);
	}

	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page) {
		return operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, page);
	}

	@Override
	@WebMethod(operationName = "getOperationsCarteByMonthPaginatedCustom")
	public List<Operation> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults) {
		return operationService.getOperationsCarteByMonthPaginated(idCompte, month, year, offset, numberOfResults);
	}

	@Override
	public List<Operation> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page) {
		return operationService.getOperationsCarteByMonthPaginated(idCompte, month, year, page);
	}

	@Override
	@WebMethod(operationName = "getVirementsByMonthPaginatedCustom")
	public List<Operation> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults) {
		return operationService.getVirementsByMonthPaginated(idCompte, month, year, offset, numberOfResults);
	}

	@Override
	public List<Operation> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page) {
		return operationService.getVirementsByMonthPaginated(idCompte, month, year, page);
	}

	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getNumberOfPagesForOperationsWithoutCartesByMonthCustom")
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "numberOfResults") int numberOfResults) {
		return operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year,
				numberOfResults);
	}

	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getNumberOfPagesForOperationsCartesByMonthCustom")
	public long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults) {
		return operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, years, numberOfResults);
	}

	@Override
	public long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getNumberOfPagesForVirementByMonth(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "getNumberOfPagesForVirementByMonthCustom")
	public long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults) {
		return operationService.getNumberOfPagesForVirementByMonth(idCompte, month, years, numberOfResults);
	}

	@Override
	public List<Operation> getAllOperationsByMonthByCompte(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year) {
		return operationService.getAllOperationsByMonthByCompte(idCompte, month, year);
	}

	@Override
	@WebMethod(operationName = "doVirementInterne")
	public ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") long idCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant) {
		System.out.println(idCompteADebiter);
		System.out.println(idCompteACrediter);
		System.out.println(label);
		System.out.println(montant);
		return operationService.doVirement(idCompteADebiter, idCompteACrediter, label, montant);
	}

	@Override
	@WebMethod(operationName = "doVirementExterne")
	public ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") String numeroCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant) {
		return operationService.doVirement(idCompteADebiter, numeroCompteACrediter, label, montant);
	}
}