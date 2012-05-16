package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kpogorzelski
 * 
 */
@Controller
public class Login {

	/**
	 * @return String
	 */
	@RequestMapping("/login.php")
	public String redirect() {
		return "login";
	}
}
