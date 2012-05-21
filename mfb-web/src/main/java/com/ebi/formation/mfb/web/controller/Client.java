package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller gérant l'accès à la partie client de l'application.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
@RequestMapping("/client")
public class Client {

	/**
	 * @return String
	 */
	@RequestMapping("home.html")
	public String redirect() {
		return "home";
	}
}
