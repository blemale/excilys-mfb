package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.joda.time.DateTime;

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
	 * @param page
	 * @return
	 */
	List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year, @WebParam(name = "page") int page);

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
	 * @return
	 */
	long getNumberOfPagesForOperationsCartesByMonth(@WebParam(name = "idCompte") long idCompte,
			@WebParam(name = "month") int month, @WebParam(name = "year") int year);

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
			@WebParam(name = "montant") BigDecimal montant, @WebParam(name = "dateEffet") DateTime dateEffet,
			@WebParam(name = "dateValeur") DateTime dateValeur);

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
			@WebParam(name = "montant") BigDecimal montant, @WebParam(name = "dateEffet") DateTime dateEffet,
			@WebParam(name = "dateValeur") DateTime dateValeur);
}
