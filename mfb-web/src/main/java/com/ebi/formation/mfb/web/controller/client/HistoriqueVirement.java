package com.ebi.formation.mfb.web.controller.client;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.ICompteService;

@Controller
@RequestMapping("/client/virement/")
public class HistoriqueVirement {

	@Autowired
	ICompteService compteService;

	/**
	 * Retourne une vue associée à la liste des comptes d'un utilisateur via son username
	 * 
	 * @param principal
	 * @return ModelAndView
	 */
	@RequestMapping(value = "listeCompte.html", method = RequestMethod.GET)
	public ModelAndView listeCompte(Principal principal) {
		return new ModelAndView("historiqueVirement", "comptes", compteService.findComptesByUsername(principal
				.getName()));
	}

	/**
	 * Retourne une vue associée à l'historique des virements d'un compte
	 * 
	 * @param principal
	 * @return ModelAndView
	 */
	@RequestMapping(value = "compte/{idCompte:\\d+}/historique.html", method = RequestMethod.GET)
	public ModelAndView historiqueVirementCompte(Principal principal) {
		List<Operation> virements = new ArrayList<Operation>();
		virements.add(new Operation());
		virements.add(new Operation());
		virements.add(new Operation());
		virements.add(new Operation());
		return new ModelAndView("listCompteHistorique", "virements", virements);
	}
}
