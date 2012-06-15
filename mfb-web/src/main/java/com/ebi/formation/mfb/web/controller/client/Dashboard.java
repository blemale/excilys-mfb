package com.ebi.formation.mfb.web.controller.client;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.servicesapi.ICompteService;
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
	private ICompteService compteService;

	/**
	 * Retourne une vue associée à la liste des comptes d'un utilisateur via son username
	 * 
	 * @param principal
	 * @return ModelAndView
	 */
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public ModelAndView redirect(Principal principal) {
		ModelAndView mv = new ModelAndView("home");
		List<Compte> comptes = compteService.findComptesByUsername(principal.getName());
		mv.addObject("comptes", comptes);
		mv.addObject("linksDetail", getMapLinksDetailByCompteId(comptes));
		mv.addObject("linksVirement", getMapLinksVirementByCompteId(comptes));
		Map<String, String> linksfilAriane = new LinkedHashMap<String, String>();
		linksfilAriane.put("linkFilAriane.home", LinkBuilder.getLink("client", "home.html"));
		mv.addObject("linksfilAriane", linksfilAriane);
		return mv;
	}

	/**
	 * Créer une map regroupant l'url du détail d'un compte associé à celui-ci
	 * 
	 * @param comptes
	 * @return
	 */
	private Map<Long, String> getMapLinksDetailByCompteId(List<Compte> comptes) {
		Map<Long, String> mapLinksDetailById = new HashMap<Long, String>();
		for (Compte c : comptes) {
			mapLinksDetailById.put(c.getId(), LinkBuilder.getLink("client", "compte", c.getId(), "detail.html"));
		}
		return mapLinksDetailById;
	}

	/**
	 * Créer une map regroupant l'url du détail des virements d'un compte associé à celui-ci
	 * 
	 * @param comptes
	 * @return
	 */
	private Map<Long, String> getMapLinksVirementByCompteId(List<Compte> comptes) {
		Map<Long, String> mapLinksVirementById = new HashMap<Long, String>();
		for (Compte c : comptes) {
			mapLinksVirementById.put(c.getId(),
					LinkBuilder.getLink("client", "compte", c.getId(), "virement", "history.html"));
		}
		return mapLinksVirementById;
	}
}
