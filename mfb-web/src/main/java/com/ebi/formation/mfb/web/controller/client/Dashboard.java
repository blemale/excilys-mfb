package com.ebi.formation.mfb.web.controller.client;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.web.utils.LinkBuilder;

/**
 * Controller gérant l'accès au dashboard.
 * 
 * @author kpogorzelski
 * 
 */
@Controller
@RequestMapping("/client")
public class Dashboard {

	@Autowired
	ICompteService compteService;

	/**
	 * Retourne une vue associée à la liste des comptes d'un utilisateur via son username
	 * 
	 * @param principal
	 * @return ModelAndView
	 */
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public ModelAndView redirect(Principal principal) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("linksAndComptes", getLinksAndComptes(compteService.findComptesByUsername(principal.getName())));
		return mv;
	}

	/**
	 * Créer une map regroupant l'url du détail d'un compte associé à celui-ci
	 * 
	 * @param comptes
	 * @return
	 */
	private Map<String, Compte> getLinksAndComptes(List<Compte> comptes) {
		Map<String, Compte> mapLinksAndComptes = new LinkedHashMap<String, Compte>();
		for (Compte c : comptes) {
			mapLinksAndComptes.put(LinkBuilder.getLink("client", "compte", c.getId(), "detail.html"), c);
		}
		return mapLinksAndComptes;
	}
}
