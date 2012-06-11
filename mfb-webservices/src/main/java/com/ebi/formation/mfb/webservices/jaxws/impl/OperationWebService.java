package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.services.IOperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.webservices.dto.OperationDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService;

@WebService(endpointInterface = "com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService")
public class OperationWebService implements IOperationWebService {

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
	public List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		return convertListOperationToListOperationDTO(operationService.getOperationsWithoutCarteByMonthPaginated(
				idCompte, month, year, offset, numberOfResults));
	}

	@Override
	public List<OperationDTO> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		return convertListOperationToListOperationDTO(operationService.getOperationsWithoutCarteByMonthPaginated(
				idCompte, month, year, page));
	}

	@Override
	public List<OperationDTO> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		return convertListOperationToListOperationDTO(operationService.getOperationsCarteByMonthPaginated(idCompte,
				month, year, offset, numberOfResults));
	}

	@Override
	public List<OperationDTO> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page) {
		return convertListOperationToListOperationDTO(operationService.getOperationsCarteByMonthPaginated(idCompte,
				month, year, page));
	}

	@Override
	public List<OperationDTO> getVirementsByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults) {
		return convertListOperationToListOperationDTO(operationService.getVirementsByMonthPaginated(idCompte, month,
				year, offset, numberOfResults));
	}

	@Override
	public List<OperationDTO> getVirementsByMonthPaginated(long idCompte, int month, int year, int page) {
		return convertListOperationToListOperationDTO(operationService.getVirementsByMonthPaginated(idCompte, month,
				year, page));
	}

	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year,
			int numberOfResults) {
		return operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year,
				numberOfResults);
	}

	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int years, int numberOfResults) {
		return operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, years, numberOfResults);
	}

	@Override
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int year) {
		return operationService.getNumberOfPagesForVirementByMonth(idCompte, month, year);
	}

	@Override
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int years, int numberOfResults) {
		return operationService.getNumberOfPagesForVirementByMonth(idCompte, month, years, numberOfResults);
	}

	@Override
	public List<OperationDTO> getAllOperationsByMonthByCompte(long idCompte, int month, int year) {
		return convertListOperationToListOperationDTO(operationService.getAllOperationsByMonthByCompte(idCompte, month,
				year));
	}

	@Override
	public ReturnCodeVirement doVirement(long idCompteADebiter, long idCompteACrediter, String label, BigDecimal montant) {
		return operationService.doVirement(idCompteADebiter, idCompteACrediter, label, montant);
	}

	@Override
	public ReturnCodeVirement doVirement(long idCompteADebiter, String numeroCompteACrediter, String label,
			BigDecimal montant) {
		return operationService.doVirement(idCompteADebiter, numeroCompteACrediter, label, montant);
	}

	private OperationDTO convertOperationToOperationDTO(Operation operation) {
		return new OperationDTO(operation.getId(), operation.getType(), operation.getMontant(),
				operation.getDateValeur(), operation.getDateEffet(), operation.getLabel());
	}

	private List<OperationDTO> convertListOperationToListOperationDTO(List<Operation> operations) {
		List<OperationDTO> operationDTOs = new ArrayList<OperationDTO>();
		for (Operation o : operations) {
			operationDTOs.add(convertOperationToOperationDTO(o));
		}
		return operationDTOs;
	}
}