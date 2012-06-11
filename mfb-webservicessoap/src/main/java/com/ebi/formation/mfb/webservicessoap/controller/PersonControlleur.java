package com.ebi.formation.mfb.webservicessoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.webservices.dto.PersonDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService;

/**
 * Classe gérant les tests liées aux WebServices des Personnes
 * 
 * @author excilys
 * 
 */
@Controller
public class PersonControlleur {

	@Autowired
	private IPersonWebService personWebService;

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

	/**
	 * Test de la méthode findAllPersons
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findAllPersons.html", method = RequestMethod.GET)
	public ModelAndView testFindAllPersons() {
		List<PersonDTO> persons = personWebService.findAllPersons();
		return new ModelAndView("person/findAllPersons", "persons", persons);
	}
}
