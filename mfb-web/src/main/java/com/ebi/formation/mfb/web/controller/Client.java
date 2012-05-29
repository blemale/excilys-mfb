package com.ebi.formation.mfb.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
	 * Par défaut
	 * 
	 * @param principal
	 * @param idCompte
	 * @return
	 */
	@RequestMapping(value = "/compte/{idCompte:\\d+}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompte(Principal principal, Locale locale, @PathVariable Long idCompte) {
		return detailCompteMois(principal, locale, idCompte, DateTime.now().getYear(), DateTime.now().getMonthOfYear());
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
	public ModelAndView detailCompteMois(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month) {
		return detailCompteMoisAndPage(principal, locale, idCompte, year, month, 0);
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
	public ModelAndView detailCompteMoisAndPage(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month, @PathVariable int page) {
		if (!compteService.checkCompteOwnershipByUsernameAndCompteId(principal.getName(), idCompte)
				|| !monthInHistory(month, year) || !pageExistWithoutCarte(idCompte, year, month, page)) {
			throw new ResourceNotFoundException();
		}
		ModelAndView mv = new ModelAndView("detailCompte");
		mv.addObject("operations",
				operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, page));
		mv.addObject("soldeCarte", operationService.getTotalOperationsCarteByMonth(idCompte, month, year));
		mv.addObject("compte", compteService.getCompteById(idCompte));
		if (hasPreviousMonth(month, year)) {
			DateTime monthBefore = DateTime.now().minusMonths(1);
			mv.addObject(
					"previousMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "detail.html"));
		}
		if (hasNextMonth(month, year)) {
			DateTime monthBefore = DateTime.now().plusMonths(1);
			mv.addObject(
					"nextMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "detail.html"));
		}
		mv.addObject("currentYear", year);
		mv.addObject("currentMonth", month);
		long nbPages = operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
		mv.addObject("numPageMonth", nbPages);
		mv.addObject("urlPages", getPagesUrlsWithoutCarte(idCompte, year, month, nbPages));
		mv.addObject("currentPage", page);
		mv.addObject("urlDetailCarte",
				LinkBuilder.getLink("client", "compte", idCompte, year, month, "carte", "detail.html"));
		mv.addObject("mapNamesUrlsForMonths", getMonthUrlsWithoutCarte(locale, idCompte));
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
	public ModelAndView detailCompteCarte(Principal principal, Locale locale, @PathVariable Long idCompte) {
		return detailCompteCarteMois(principal, locale, idCompte, DateTime.now().getYear(), DateTime.now()
				.getMonthOfYear());
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
	public ModelAndView detailCompteCarteMois(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month) {
		return detailCompteCarteMoisAndPage(principal, locale, idCompte, year, month, 0);
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
	public ModelAndView detailCompteCarteMoisAndPage(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month, @PathVariable int page) {
		if (!compteService.checkCompteOwnershipByUsernameAndCompteId(principal.getName(), idCompte)
				|| !monthInHistory(month, year) || !pageExistCarte(idCompte, year, month, page)) {
			throw new ResourceNotFoundException();
		}
		ModelAndView mv = new ModelAndView("detailCompteCarte");
		mv.addObject("operations", operationService.getOperationsCarteByMonthPaginated(idCompte, month, year, page));
		mv.addObject("soldeCarte", operationService.getTotalOperationsCarteByMonth(idCompte, month, year));
		mv.addObject("compte", compteService.getCompteById(idCompte));
		if (hasPreviousMonth(month, year)) {
			DateTime monthBefore = DateTime.now().minusMonths(1);
			mv.addObject(
					"previousMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "carte", "detail.html"));
		}
		if (hasNextMonth(month, year)) {
			DateTime monthBefore = DateTime.now().plusMonths(1);
			mv.addObject(
					"nextMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "carte", "detail.html"));
		}
		mv.addObject("currentYear", year);
		mv.addObject("currentMonth", month);
		long nbPages = operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
		mv.addObject("numPageMonth", nbPages);
		mv.addObject("urlPages", getPagesUrlsCarte(idCompte, year, month, nbPages));
		mv.addObject("currentPage", page);
		mv.addObject("urlDetailCompte", LinkBuilder.getLink("client", "compte", idCompte, year, month, "detail.html"));
		mv.addObject("mapNamesUrlsForMonths", getMonthUrlsCarte(locale, idCompte));
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

	private boolean pageExistWithoutCarte(Long idCompte, int year, int month, int page) {
		return 0L <= page
				&& page <= operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
	}

	private boolean pageExistCarte(Long idCompte, int year, int month, int page) {
		return 0L <= page && page <= operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
	}

	private List<String> getPagesUrlsWithoutCarte(Long idCompte, int year, int month, long nbPages) {
		List<String> urls = new ArrayList<String>();
		for (long indexPage = 0; indexPage < nbPages; indexPage++) {
			urls.add(LinkBuilder.getLink("client", "compte", idCompte, year, month, indexPage, "detail.html"));
		}
		return urls;
	}

	private List<String> getPagesUrlsCarte(Long idCompte, int year, int month, long nbPages) {
		List<String> urls = new ArrayList<String>();
		for (long indexPage = 0; indexPage < nbPages; indexPage++) {
			urls.add(LinkBuilder.getLink("client", "compte", idCompte, year, month, indexPage, "carte", "detail.html"));
		}
		return urls;
	}

	private Map<String, String> getMonthUrlsWithoutCarte(Locale locale, Long idCompte) {
		Map<String, String> mapNamesUrls = new HashMap<String, String>();
		DateTime now = DateTime.now();
		for (int i = 0; i <= 5; i++) {
			DateTime month = now.minusMonths(i);
			DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM YYYY");
			DateTimeFormatter localeFmt = fmt.withLocale(locale);
			mapNamesUrls.put(localeFmt.print(month), LinkBuilder.getLink("client", "compte", idCompte, month.getYear(),
					month.getMonthOfYear(), "detail.html"));
		}
		return mapNamesUrls;
	}

	private Map<String, String> getMonthUrlsCarte(Locale locale, Long idCompte) {
		Map<String, String> mapNamesUrls = new HashMap<String, String>();
		DateTime now = DateTime.now();
		for (int i = 0; i <= 5; i++) {
			DateTime month = now.minusMonths(i);
			DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM YYYY");
			DateTimeFormatter localeFmt = fmt.withLocale(locale);
			mapNamesUrls.put(localeFmt.print(month), LinkBuilder.getLink("client", "compte", idCompte, month.getYear(),
					month.getMonthOfYear(), "carte", "detail.html"));
		}
		return mapNamesUrls;
	}
}
