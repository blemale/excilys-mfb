package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller gérant l'accès à la partie admin de l'application.
 * 
 * @author fguillain
 * 
 */
@Controller
@RequestMapping("/admin")
public class Admin {

	/**
	 * @return
	 */
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public ModelAndView redirect() {
		ModelAndView mv = new ModelAndView("admin");
		// initialisation
		String[] tabClassActive = { "", "", "" };
		mv.addObject("classActive", tabClassActive);
		return mv;
	}
}
