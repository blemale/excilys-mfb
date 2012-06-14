package com.ebi.formation.mfb.clientwebservicesrest.controller;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebi.formation.mfb.entities.OperationType.Type;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;
import com.ebi.formation.mfb.webservicesapi.dto.IntegrationOperationDTO;
import com.ebi.formation.mfb.webservicesapi.jaxrs.ICompteWebService;
import com.ebi.formation.mfb.webservicesapi.jaxrs.IOperationWebService;

@Controller
public class OperationController {

	@Autowired
	IOperationWebService operationWebService;
	@Autowired
	ICompteWebService compteWebService;

	@RequestMapping(value = "addNewOperation.html", method = RequestMethod.GET)
	public String addNewOperation() {
		CompteDTO compte = compteWebService.findComptesByUsername("user").get(0);
		IntegrationOperationDTO operationDTO = new IntegrationOperationDTO(compte.getNumeroCompte(), Type.CHEQUE,
				new BigDecimal(100), DateTime.now(), DateTime.now(), "Test webservice");
		operationWebService.addNewOperation(operationDTO);
		return "redirect:index.html";
	}
}
