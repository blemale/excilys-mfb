package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.services.IOperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.webservices.dto.OperationDTO;

@WebService
public interface IOperationWebService {

	public BigDecimal getTotalOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	public long getNumberOfOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	public long getNumberOfOperationsWithoutCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	public long getNumberOfVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getOperationsWithoutCarteByMonthPaginatedCustom")
	public List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	public List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	@WebMethod(operationName = "getOperationsCarteByMonthPaginatedCustom")
	public List<OperationDTO> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	public List<OperationDTO> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	@WebMethod(operationName = "getVirementsByMonthPaginatedCustom")
	public List<OperationDTO> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	public List<OperationDTO> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	public long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getNumberOfPagesForOperationsWithoutCartesByMonthCustom")
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "numberOfResults") int numberOfResults);

	public long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getNumberOfPagesForOperationsCartesByMonthCustom")
	public long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	public long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getNumberOfPagesForVirementByMonthCustom")
	public long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	public List<OperationDTO> getAllOperationsByMonthByCompte(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "doVirementInterne")
	public ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") long idCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);

	@WebMethod(operationName = "doVirementExterne")
	public ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") String numeroCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);
}
