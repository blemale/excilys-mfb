package com.ebi.formation.mfb.web.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.services.ICompteService;

/**
 * Controller gérant l'accès à la partie client de l'application.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
@RequestMapping("/client")
public class Client {

	@Autowired
	ICompteService compteService;

	/**
	 * Retourne une vue associée à la liste des comptes d'un utilisateur via son username
	 * 
	 * @param principal
	 * @return ModelAndView
	 */
	@RequestMapping("home.html")
	public ModelAndView redirect(Principal principal) {
		return new ModelAndView("home", "comptes", compteService.findComptesByUsername(principal.getName()));
	}

	@RequestMapping(value = "/compte/{idCompte:\\d+}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompte(Principal principal, @PathVariable Long idCompte) {
		ModelAndView mv = new ModelAndView("detailCompte");
		mv.addObject("previousMonth", true);
		mv.addObject("nextMonth", false);
		mv.addObject("numMonthHistory", 5);
		mv.addObject("numPageMonth", 5);
		mv.addObject("carte", true);
		mv.addObject("soldeCarte", 123.456);
		mv.addObject("operations", new ArrayList<Object>());
		mv.addObject("idCompte", idCompte);
		mv.addObject("currentYear", DateTime.now().getYear());
		mv.addObject("currentMonth", DateTime.now().getMonthOfYear());
		mv.addObject("currentPage", 0);
		return mv;
	}

	@RequestMapping(value = "/compte/{idCompte:\\d+}/{year:20\\d{2}}/{month:[1-9]|1[012]}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteMois(Principal principal, @PathVariable Long idCompte, @PathVariable int year,
			@PathVariable int month) {
		ModelAndView mv = new ModelAndView("detailCompte");
		mv.addObject("previousMonth", true);
		mv.addObject("nextMonth", false);
		mv.addObject("numMonthHistory", 5);
		mv.addObject("numPageMonth", 5);
		mv.addObject("carte", true);
		mv.addObject("soldeCarte", 123.456);
		mv.addObject("operations", new ArrayList<Object>());
		mv.addObject("idCompte", idCompte);
		mv.addObject("currentYear", year);
		mv.addObject("currentMonth", month);
		mv.addObject("currentPage", 0);
		return mv;
	}

	@RequestMapping(value = "/compte/{idCompte:\\d+}/{year}/{month:[1-9]|1[012]}/{page:[0-9]+}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteMoisAndPage(Principal principal, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month, @PathVariable int page) {
		ModelAndView mv = new ModelAndView("detailCompte");
		mv.addObject("previousMonth", true);
		mv.addObject("nextMonth", false);
		mv.addObject("numMonthHistory", 5);
		mv.addObject("numPageMonth", 5);
		mv.addObject("carte", true);
		mv.addObject("soldeCarte", 123.456);
		mv.addObject("operations", new ArrayList<Object>());
		mv.addObject("idCompte", idCompte);
		mv.addObject("currentYear", year);
		mv.addObject("currentMonth", month);
		mv.addObject("currentPage", page);
		return mv;
	}
}
