package com.ebi.formation.mfb.web.controller.admin;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.web.forms.admin.CompteForm;

/**
 * Controller permettant de gérer un compte
 * 
 * @author fguillain
 * 
 */
@Controller
@RequestMapping("/admin")
public class Compte {

	/**
	 * @param principal
	 * @param compteForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "doCreateCompte.html", method = RequestMethod.POST)
	public ModelAndView doCreateCompte(Principal principal, @ModelAttribute @Valid CompteForm compteForm,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("admin");
		String[] tabClassActive = { "", "active", "" };
		mv.addObject("classActive", tabClassActive);
		if (result.hasErrors()) {
			mv.addObject("ownersList", null);
			mv.setViewName("createCompte");
		}
		return mv;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "createCompte.html")
	public ModelAndView createCompteForm() {
		ModelAndView mv = new ModelAndView("createCompte");
		String[] tabClassActive = { "", "active", "" };
		mv.addObject("classActive", tabClassActive);
		mv.addObject("ownersList", null);
		mv.addObject(new CompteForm());
		return mv;
	}
}
