package com.ebi.formation.mfb.webservicessoap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe gérant les tests liées aux WebServices du Compte
 * 
 * @author excilys
 * 
 */
@Controller
public class CompteControlleur {

	/**
	 * Test de la méthode getCompteById
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCompteById.html", method = RequestMethod.GET)
	public ModelAndView test() {
		return new ModelAndView("compte/getCompteById");
	}
}
