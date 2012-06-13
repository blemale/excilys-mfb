package com.ebi.formation.mfb.webservices.jaxrs.impl;

import java.util.List;

import javax.ws.rs.Produces;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;
import com.ebi.formation.mfb.webservicesapi.jaxrs.IOperationWebService;

@Produces({ "application/json", "text/xml" })
public class OperationWebService implements IOperationWebService {

	@Autowired
	private IOperationService operationService;
	@Autowired
	private DTOBinder binder;

	@Override
	public List<OperationDTO> getLastFiveOperationsByCompteId(Long compteId, int numberOfOperations) {
		List<OperationDTO> operationDTOs = binder.bindFromBusinessObjectList(OperationDTO.class,
				operationService.getLastOperationByCompte(compteId, numberOfOperations));
		return operationDTOs;
	}
}
