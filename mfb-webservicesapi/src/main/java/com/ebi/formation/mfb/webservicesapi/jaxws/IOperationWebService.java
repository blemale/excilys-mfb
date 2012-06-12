package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.services.IOperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;

@WebService
public interface IOperationWebService {

	BigDecimal getTotalOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	long getNumberOfOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	long getNumberOfOperationsWithoutCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	long getNumberOfVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getOperationsWithoutCarteByMonthPaginatedCustom")
	List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	@WebMethod(operationName = "getOperationsCarteByMonthPaginatedCustom")
	List<OperationDTO> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	List<OperationDTO> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	@WebMethod(operationName = "getVirementsByMonthPaginatedCustom")
	List<OperationDTO> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	List<OperationDTO> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getNumberOfPagesForOperationsWithoutCartesByMonthCustom")
	long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "numberOfResults") int numberOfResults);

	long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getNumberOfPagesForOperationsCartesByMonthCustom")
	long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "getNumberOfPagesForVirementByMonthCustom")
	long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	List<OperationDTO> getAllOperationsByMonthByCompte(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	@WebMethod(operationName = "doVirementInterne")
	ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") long idCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);

	@WebMethod(operationName = "doVirementExterne")
	ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") String numeroCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);
}
