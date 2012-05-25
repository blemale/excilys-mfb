package com.ebi.formation.mfb.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.web.utils.SessionAttributesNames;

/**
 * Controller qui gère l'accès aux différentes pages home.html suivant les droits de l'utilisateur.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
public class Home {

	@Autowired
	private IPersonService personService;

	/**
	 * @return String
	 */
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public String redirect(HttpServletRequest request, Principal principal) {
		HttpSession session = request.getSession();
		if (principal != null && session.getAttribute(SessionAttributesNames.USER_LASTNAME) == null
				&& session.getAttribute(SessionAttributesNames.USER_FIRSTNAME) == null) {
			Person p = personService.findPersonByUsername(principal.getName());
			session.setAttribute(SessionAttributesNames.USER_FIRSTNAME, p.getFirstName());
			session.setAttribute(SessionAttributesNames.USER_LASTNAME, p.getLastName());
		}
		if (request.isUserInRole(Right.ROLE_CLIENT.name())) {
			return "redirect:/client/home.html";
		} else if (request.isUserInRole(Right.ROLE_ADMIN.name())) {
			return "redirect:/admin/home.html";
		} else {
			return "redirect:/login.html";
		}
	}
}
