package com.ebi.formation.mfb.webservices.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.IOperationService;

@WebService
public interface IOperationWebService extends IOperationService {

	@Override
	public BigDecimal getTotalOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	public long getNumberOfOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	public long getNumberOfOperationsWithoutCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	public long getNumberOfVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	@WebMethod(operationName = "getOperationsWithoutCarteByMonthPaginatedCustom")
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	@Override
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	@Override
	@WebMethod(operationName = "getOperationsCarteByMonthPaginatedCustom")
	public List<Operation> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	@Override
	public List<Operation> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	@Override
	@WebMethod(operationName = "getVirementsByMonthPaginatedCustom")
	public List<Operation> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	@Override
	public List<Operation> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	@WebMethod(operationName = "getNumberOfPagesForOperationsWithoutCartesByMonthCustom")
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "numberOfResults") int numberOfResults);

	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	@WebMethod(operationName = "getNumberOfPagesForOperationsCartesByMonthCustom")
	public long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	@Override
	public long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	@WebMethod(operationName = "getNumberOfPagesForVirementByMonthCustom")
	public long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	@Override
	public List<Operation> getAllOperationsByMonthByCompte(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@Override
	@WebMethod(operationName = "doVirementInterne")
	public ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") long idCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);

	@Override
	@WebMethod(operationName = "doVirementExterne")
	public ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") String numeroCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);
}
