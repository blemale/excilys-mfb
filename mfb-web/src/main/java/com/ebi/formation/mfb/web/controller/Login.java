package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kpogorzelski
 * 
 */
@Controller
public class Login {

	/**
	 * @return String
	 */
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String redirect() {
		return "login";
	}
}
