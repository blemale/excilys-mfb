package com.ebi.formation.mfb.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller gérant l'accès à la partie client de l'application.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
@RequestMapping("/client")
public class Client {

	/**
	 * @return String
	 */
	@RequestMapping("home.html")
	public ModelAndView redirect() {
		/*
		 * TODO Aller chercher la liste des comptes du clients
		 */
		List<String> comptes = new ArrayList<String>();
		comptes.add("toto");
		comptes.add("titi");
		comptes.add("tutu");
		return new ModelAndView("home", "comptes", comptes);
	}
}
