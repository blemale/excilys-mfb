package com.ebi.formation.mfb.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebi.formation.mfb.entities.Role.Right;

/**
 * @author excilys
 * 
 */
@Controller
public class Login {

	/**
	 * @return String
	 */
	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String redirect(HttpServletRequest request) {
		if (request.isUserInRole(Right.ROLE_CLIENT.name())) {
			return "redirect:/client/home.html";
		} else if (request.isUserInRole(Right.ROLE_ADMIN.name())) {
			return "redirect:/admin/home.html";
		} else {
			return "login";
		}
	}
}
