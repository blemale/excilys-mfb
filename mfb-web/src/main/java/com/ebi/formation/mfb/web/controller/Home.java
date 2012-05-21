package com.ebi.formation.mfb.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebi.formation.mfb.entities.Role.Right;

/**
 * Controller qui gère l'accès aux différentes pages home.html suivant les droits de l'utilisateur.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
public class Home {

	/**
	 * @return String
	 */
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public String redirect(HttpServletRequest request) {
		if (request.isUserInRole(Right.ROLE_CLIENT.name())) {
			return "redirect:/client/home.html";
		} else if (request.isUserInRole(Right.ROLE_ADMIN.name())) {
			return "redirect:/admin/home.html";
		} else {
			return "redirect:/login.html";
		}
	}
}
