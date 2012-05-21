package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller gérant l'accès à la partie admin de l'application.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
public class Admin {

	/**
	 * @return String
	 */
	@RequestMapping("/admin/home.html")
	public String redirect() {
		return "admin";
	}
}
