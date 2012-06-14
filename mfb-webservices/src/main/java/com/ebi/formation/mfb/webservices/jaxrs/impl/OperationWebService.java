package com.ebi.formation.mfb.webservices.jaxrs.impl;

import java.util.List;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.services.IOperationService.ReturnCodeOperation;
import com.ebi.formation.mfb.webservicesapi.dto.IntegrationOperationDTO;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;
import com.ebi.formation.mfb.webservicesapi.jaxrs.IOperationWebService;

/**
 * Implémentation de {@link IOperationWebService}
 * 
 * @author excilys
 * 
 */
public class OperationWebService implements IOperationWebService {

	@Autowired
	private IOperationService operationService;
	@Autowired
	private DTOBinder binder;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxrs.IOperationWebService#getLastOperationsByCompteId(java.lang.Long,
	 * int)
	 */
	@Override
	public List<OperationDTO> getLastOperationsByCompteId(Long compteId, int numberOfOperations) {
		List<OperationDTO> operationDTOs = binder.bindFromBusinessObjectList(OperationDTO.class,
				operationService.getLastOperationByCompte(compteId, numberOfOperations));
		return operationDTOs;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.webservicesapi.jaxrs.IOperationWebService#addNewOperation(com.ebi.formation.mfb.webservicesapi
	 * .dto.IntegrationOperationDTO)
	 */
	@Override
	public Boolean addNewOperation(IntegrationOperationDTO integrationOperationDTO) {
		ReturnCodeOperation returnedCode = operationService.saveOperation(integrationOperationDTO.getMontant(),
				integrationOperationDTO.getNumeroCompte(), integrationOperationDTO.getType(),
				integrationOperationDTO.getLabel(), integrationOperationDTO.getDateEffet(),
				integrationOperationDTO.getDateValeur());
		if (returnedCode.equals(ReturnCodeOperation.OK)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
