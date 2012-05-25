package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller gérant l'accès à la partie admin de l'application.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
@RequestMapping("/admin")
public class Admin {

	/**
	 * @return String
	 */
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public String redirect() {
		return "admin";
	}
}
