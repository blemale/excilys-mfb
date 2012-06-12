package com.ebi.formation.mfb.clientwebservicesrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;
import com.ebi.formation.mfb.webservicesapi.jaxrs.IPersonneWebService;

/**
 * Classe gérant les tests liées aux WebServices des Personnes
 * 
 * @author excilys
 * 
 */
@Controller
public class PersonController {

	@Autowired
	private IPersonneWebService personWebService;

	/**
	 * Test de la méthode findPersonByUsername
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findPersonByUsername.html", method = RequestMethod.GET)
	public ModelAndView testFindPersonByUsername() {
		PersonDTO person = personWebService.findPersonByUsername("user");
		return new ModelAndView("person/findPersonByUsername", "person", person);
	}
}
