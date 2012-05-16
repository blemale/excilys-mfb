package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kpogorzelski
 * 
 */
@Controller
public class Home {

	/**
	 * @return String
	 */
	@RequestMapping("home.html")
	public String redirect() {
		return "home";
	}
}
