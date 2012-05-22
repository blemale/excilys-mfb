package com.ebi.formation.mfb.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.services.IPersonService;

/**
 * Controller gérant l'accès à la partie client de l'application.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
@RequestMapping("/client")
public class Client {

	@Autowired
	IPersonService personService;

	/**
	 * Retourne une vue associée à la liste des comptes d'un utilisateur via son username
	 * 
	 * @param principal
	 * @return ModelAndView
	 */
	@RequestMapping("home.html")
	public ModelAndView redirect(Principal principal) {
		return new ModelAndView("home", "comptes", personService.findComptesByUsername(principal.getName()));
	}
}
