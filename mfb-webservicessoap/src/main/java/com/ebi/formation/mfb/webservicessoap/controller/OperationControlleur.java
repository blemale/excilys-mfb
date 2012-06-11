package com.ebi.formation.mfb.webservicessoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.IOperationWebService;

/**
 * Classe gérant les tests liées aux WebServices des Opérations
 * 
 * @author excilys
 * 
 */
@Controller
public class OperationControlleur {

	@Autowired
	private IOperationWebService operationWebService;

	/**
	 * Test de la méthode findPersonByUsername
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getOperationsWithoutCarteByMonthPaginated.html", method = RequestMethod.GET)
	public ModelAndView testGetOperationsWithoutCarteByMonthPaginated() {
		List<OperationDTO> operations = operationWebService.getOperationsWithoutCarteByMonthPaginated(7L, 05, 2012, 0);
		return new ModelAndView("operation/getOperationsWithoutCarteByMonthPaginated", "operations", operations);
	}

	/**
	 * Test de la méthode getVirementsByMonthPaginated
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getVirementsByMonthPaginated.html", method = RequestMethod.GET)
	public ModelAndView testGetVirementsByMonthPaginated() {
		List<OperationDTO> operations = operationWebService.getVirementsByMonthPaginated(7L, 05, 2012, 0);
		return new ModelAndView("operation/getVirementsByMonthPaginated", "operations", operations);
	}
}
