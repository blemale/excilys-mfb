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
import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.web.exception.ResourceNotFoundException;
import com.ebi.formation.mfb.web.utils.LinkBuilder;

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
	@Autowired
	IOperationService operationService;

	/**
	 * Retourne une vue associée à la liste des comptes d'un utilisateur via son username
	 * 
	 * @param principal
	 * @return ModelAndView
	 */
	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public ModelAndView redirect(Principal principal) {
		return new ModelAndView("home", "comptes", compteService.findComptesByUsername(principal.getName()));
	}

	/**
	 * 
	 * 
	 * @param month
	 * @return
	 */
	private int[] calcTabMonthHistory(int month) {
		int currentMonth = DateTime.now().getMonthOfYear();
		int tabMonthHistory[] = new int[6];
		for (int i = 0; i < 6; i++) {
			tabMonthHistory[i] = currentMonth - i;
			if (tabMonthHistory[i] <= 0) {
				tabMonthHistory[i] = tabMonthHistory[i] + 12;
			}
		}
		return tabMonthHistory;
	}

	/**
	 * Par défaut
	 * 
	 * @param principal
	 * @param idCompte
	 * @return
	 */
	@RequestMapping(value = "/compte/{idCompte:\\d+}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompte(Principal principal, @PathVariable Long idCompte) {
		return detailCompteCarteMois(principal, idCompte, DateTime.now().getYear(), DateTime.now().getMonthOfYear());
	}

	/**
	 * Changement de mois
	 * 
	 * @param principal
	 * @param idCompte
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping(value = "/compte/{idCompte:\\d+}/{year:20\\d{2}}/{month:[1-9]|1[012]}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteMois(Principal principal, @PathVariable Long idCompte, @PathVariable int year,
			@PathVariable int month) {
		return detailCompteMoisAndPage(principal, idCompte, year, month, 0);
	}

	/**
	 * Changement de page
	 * 
	 * @param principal
	 * @param idCompte
	 * @param year
	 * @param month
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/compte/{idCompte:\\d+}/{year}/{month:[1-9]|1[012]}/{page:[0-9]+}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteMoisAndPage(Principal principal, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month, @PathVariable int page) {
		if (!compteService.checkCompteOwnershipByUsernameAndCompteId(principal.getName(), idCompte)
				|| !monthInHistory(month, year)) {
			throw new ResourceNotFoundException();
		}
		ModelAndView mv = new ModelAndView("detailCompte");
		mv.addObject("operations",
				operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, page));
		mv.addObject("soldeCarte", operationService.getTotalOperationsCarteByMonth(idCompte, month, year));
		mv.addObject("compte", compteService.getCompteById(idCompte));
		if (hasPreviousMonth(month, year)) {
			DateTime monthBefore = DateTime.now().minusMonths(1);
			LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
					monthBefore.getMonthOfYear(), "detail.html");
		}
		if (hasNextMonth(month, year)) {
			DateTime monthBefore = DateTime.now().plusMonths(1);
			LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
					monthBefore.getMonthOfYear(), "detail.html");
		}
		//
		// mv.addObject("previousMonth", true);
		// mv.addObject("nextMonth", true);
		mv.addObject("numPageMonth", 5);
		// mv.addObject("soldeCarte", 123.456);
		// mv.addObject("operations", new ArrayList<Object>());
		// mv.addObject("idCompte", idCompte);
		// mv.addObject("currentYear", year);
		// mv.addObject("currentMonth", month);
		mv.addObject("monthHistory", calcTabMonthHistory(month));
		mv.addObject("currentPage", page);
		return mv;
	}

	/**
	 * Par défaut
	 * 
	 * @param principal
	 * @param idCompte
	 * @return
	 */
	@RequestMapping(value = "/compte/{idCompte:\\d+}/carte/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteCarte(Principal principal, @PathVariable Long idCompte) {
		ModelAndView mv = new ModelAndView("detailCompteCarte");
		mv.addObject("previousMonth", true);
		mv.addObject("nextMonth", true);
		mv.addObject("numMonthHistory", 5);
		mv.addObject("numPageMonth", 5);
		mv.addObject("idCompte", idCompte);
		mv.addObject("currentYear", DateTime.now().getYear());
		int currentMonth = DateTime.now().getMonthOfYear();
		mv.addObject("currentMonth", currentMonth);
		mv.addObject("monthHistory", calcTabMonthHistory(currentMonth));
		mv.addObject("currentPage", 0);
		mv.addObject("cartes", new ArrayList<Object>());
		return mv;
	}

	/**
	 * Changement de mois
	 * 
	 * @param principal
	 * @param idCompte
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping(value = "/compte/{idCompte:\\d+}/{year:20\\d{2}}/{month:[1-9]|1[012]}/carte/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteCarteMois(Principal principal, @PathVariable Long idCompte, @PathVariable int year,
			@PathVariable int month) {
		ModelAndView mv = new ModelAndView("detailCompteCarte");
		mv.addObject("previousMonth", true);
		mv.addObject("nextMonth", true);
		mv.addObject("numMonthHistory", 5);
		mv.addObject("numPageMonth", 5);
		mv.addObject("carte", true);
		mv.addObject("soldeCarte", 123.456);
		mv.addObject("operations", new ArrayList<Object>());
		mv.addObject("idCompte", idCompte);
		mv.addObject("currentYear", year);
		mv.addObject("currentMonth", month);
		mv.addObject("monthHistory", calcTabMonthHistory(month));
		mv.addObject("currentPage", 0);
		return mv;
	}

	/**
	 * Changement de page
	 * 
	 * @param principal
	 * @param idCompte
	 * @param year
	 * @param month
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/compte/{idCompte:\\d+}/{year}/{month:[1-9]|1[012]}/{page:[0-9]+}/carte/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteCarteMoisAndPage(Principal principal, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month, @PathVariable int page) {
		ModelAndView mv = new ModelAndView("detailCompteCarte");
		mv.addObject("previousMonth", true);
		mv.addObject("nextMonth", true);
		mv.addObject("numMonthHistory", 5);
		mv.addObject("numPageMonth", 5);
		mv.addObject("carte", true);
		mv.addObject("soldeCarte", 123.456);
		mv.addObject("operations", new ArrayList<Object>());
		mv.addObject("idCompte", idCompte);
		mv.addObject("currentYear", year);
		mv.addObject("currentMonth", month);
		mv.addObject("monthHistory", calcTabMonthHistory(month));
		mv.addObject("currentPage", page);
		return mv;
	}

	private boolean hasPreviousMonth(int month, int year) {
		boolean result = false;
		DateTime currentMonth = new DateTime(year, month, 1, 0, 0);
		if (currentMonth.plusMonths(5).isAfterNow()) {
			result = true;
		}
		return result;
	}

	private boolean hasNextMonth(int month, int year) {
		boolean result = false;
		DateTime currentMonth = new DateTime(year, month, 1, 0, 0);
		if (currentMonth.plusMonths(1).isBeforeNow()) {
			result = true;
		}
		return result;
	}

	private boolean monthInHistory(int month, int year) {
		boolean result = false;
		DateTime currentMonth = new DateTime(year, month, 1, 0, 0);
		if (currentMonth.plusMonths(6).isAfterNow() && currentMonth.isBeforeNow()) {
			result = true;
		}
		return result;
	}
}
