package com.ebi.formation.mfb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.web.utils.SessionAttributesNames;

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
		mv.addObject(SessionAttributesNames.CLASS_ACTIVE, getClassActive(-1));
		return mv;
	}

	/**
	 * @param num
	 * @return
	 */
	public static String[] getClassActive(int num) {
		String[] tabClassActive = { "", "", "" };
		switch (num) {
			case 0:
			case 1:
			case 2:
				tabClassActive[num] = "active";
				break;
			default:
				break;
		}
		return tabClassActive;
	}
}
