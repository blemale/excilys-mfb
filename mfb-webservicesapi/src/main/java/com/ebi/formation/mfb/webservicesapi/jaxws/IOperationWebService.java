package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.services.IOperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;

/**
 * @author excilys
 * 
 */
@WebService
public interface IOperationWebService {

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	BigDecimal getTotalOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	long getNumberOfOperationsCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	long getNumberOfOperationsWithoutCarteByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	long getNumberOfVirementByMonth(@WebParam(name = "idCompte") long idCompte, @WebParam(name = "month") int month,
			@WebParam(name = "year") int year);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @param offset
	 * @param numberOfResults
	 * @return
	 */
	@WebMethod(operationName = "getOperationsWithoutCarteByMonthPaginatedCustom")
	List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @param page
	 * @return
	 */
	List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @param offset
	 * @param numberOfResults
	 * @return
	 */
	@WebMethod(operationName = "getOperationsCarteByMonthPaginatedCustom")
	List<OperationDTO> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @param page
	 * @return
	 */
	List<OperationDTO> getOperationsCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @param offset
	 * @param numberOfResults
	 * @return
	 */
	@WebMethod(operationName = "getVirementsByMonthPaginatedCustom")
	List<OperationDTO> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "offset") int offset, @WebParam(name = "numberOfResults") int numberOfResults);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @param page
	 * @return
	 */
	List<OperationDTO> getVirementsByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @param numberOfResults
	 * @return
	 */
	@WebMethod(operationName = "getNumberOfPagesForOperationsWithoutCartesByMonthCustom")
	long getNumberOfPagesForOperationsWithoutCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year,
			@WebParam(name = "numberOfResults") int numberOfResults);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	/**
	 * @param idCompte
	 * @param month
	 * @param years
	 * @param numberOfResults
	 * @return
	 */
	@WebMethod(operationName = "getNumberOfPagesForOperationsCartesByMonthCustom")
	long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	/**
	 * @param idCompte
	 * @param month
	 * @param years
	 * @param numberOfResults
	 * @return
	 */
	@WebMethod(operationName = "getNumberOfPagesForVirementByMonthCustom")
	long getNumberOfPagesForVirementByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int years,
			@WebParam(name = "numberOfResults") int numberOfResults);

	/**
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	List<OperationDTO> getAllOperationsByMonthByCompte(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

	/**
	 * @param idCompteADebiter
	 * @param idCompteACrediter
	 * @param label
	 * @param montant
	 * @return
	 */
	@WebMethod(operationName = "doVirementInterne")
	ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") long idCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);

	/**
	 * @param idCompteADebiter
	 * @param numeroCompteACrediter
	 * @param label
	 * @param montant
	 * @return
	 */
	@WebMethod(operationName = "doVirementExterne")
	ReturnCodeVirement doVirement(@WebParam(name = "idCompteADebiter") long idCompteADebiter,
			@WebParam(name = "idCompteACrediter") String numeroCompteACrediter, @WebParam(name = "label") String label,
			@WebParam(name = "montant") BigDecimal montant);
}
