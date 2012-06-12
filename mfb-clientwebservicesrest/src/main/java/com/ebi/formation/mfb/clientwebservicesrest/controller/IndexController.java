package com.ebi.formation.mfb.clientwebservicesrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlleur gérant la redirection vers l'accueil
 * 
 * @author excilys
 * 
 */
@Controller
public class IndexController {

	/**
	 * Méthode permettant d'afficher la page d'accueil
	 * 
	 * @return
	 */
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public String accueil() {
		return "index";
	}
}
