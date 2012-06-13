package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.services.IOperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService;

/**
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService")
public class OperationWebService implements IOperationWebService {

	@Autowired
	private IOperationService operationService;
	@Autowired
	private DTOBinder binder;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getTotalOperationsCarteByMonth(long, int,
	 * int)
	 */
	@Override
	public BigDecimal getTotalOperationsCarteByMonth(long idCompte, int month, int year) {
		return operationService.getTotalOperationsCarteByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getNumberOfOperationsCarteByMonth(long, int,
	 * int)
	 */
	@Override
	public long getNumberOfOperationsCarteByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfOperationsCarteByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getNumberOfOperationsWithoutCarteByMonth(long,
	 * int, int)
	 */
	@Override
	public long getNumberOfOperationsWithoutCarteByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfOperationsWithoutCarteByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getNumberOfVirementByMonth(long, int, int)
	 */
	@Override
	public long getNumberOfVirementByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfVirementByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getOperationsWithoutCarteByMonthPaginated(long,
	 * int, int, int)
	 */
	@Override
	public List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		return binder.bindFromBusinessObjectList(OperationDTO.class,
				operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, page));
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getOperationsCarteByMonthPaginated(long,
	 * int, int, int)
	 */
	@Override
	public List<OperationDTO> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		return binder.bindFromBusinessObjectList(OperationDTO.class,
				operationService.getOperationsCarteByMonthPaginated(idCompte, month, year, page));
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getVirementsByMonthPaginated(long, int, int,
	 * int)
	 */
	@Override
	public List<OperationDTO> getVirementsByMonthPaginated(long idCompte, int month, int year, int page) {
		return binder.bindFromBusinessObjectList(OperationDTO.class,
				operationService.getVirementsByMonthPaginated(idCompte, month, year, page));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getNumberOfPagesForOperationsWithoutCartesByMonth
	 * (long, int, int)
	 */
	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getNumberOfPagesForOperationsCartesByMonth(long,
	 * int, int)
	 */
	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getNumberOfPagesForVirementByMonth(long,
	 * int, int)
	 */
	@Override
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForVirementByMonth(idCompte, month, year);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#getAllOperationsByMonthByCompte(long, int,
	 * int)
	 */
	@Override
	public List<OperationDTO> getAllOperationsByMonthByCompte(long idCompte, int month, int year) {
		return binder.bindFromBusinessObjectList(OperationDTO.class,
				operationService.getAllOperationsByMonthByCompte(idCompte, month, year));
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#doVirement(long, long, java.lang.String,
	 * java.math.BigDecimal)
	 */
	@Override
	public ReturnCodeVirement doVirement(long idCompteADebiter, long idCompteACrediter, String label, BigDecimal montant) {
		return operationService.doVirement(idCompteADebiter, idCompteACrediter, label, montant);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService#doVirement(long, java.lang.String,
	 * java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public ReturnCodeVirement doVirement(long idCompteADebiter, String numeroCompteACrediter, String label,
			BigDecimal montant) {
		return operationService.doVirement(idCompteADebiter, numeroCompteACrediter, label, montant);
	}
}
