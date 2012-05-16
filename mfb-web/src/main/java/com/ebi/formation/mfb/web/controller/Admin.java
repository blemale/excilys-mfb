package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kpogorzelski
 * 
 */
@Controller
public class Admin {

	/**
	 * @return String
	 */
	@RequestMapping("admin.html")
	public String redirect() {
		return "admin";
	}
}
