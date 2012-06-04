package com.ebi.formation.mfb.web.controller.client;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.YearMonth;
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
 * Controller gérant l'accès à l'historique des virements.
 * 
 * @author excilys
 * 
 */
@Controller
@RequestMapping("/client/virement/")
public class VirementHistory {

	private static final int NB_MONTH_HISTORY = 6;
	@Autowired
	ICompteService compteService;
	@Autowired
	IOperationService operationService;

	/**
	 * Retourne la première page du détail d'un compte pour le mois en cours.
	 * 
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @return
	 */
	@RequestMapping(value = "history.html", method = RequestMethod.GET)
	public ModelAndView virementHistory(Principal principal, Locale locale) {
		return virementHistoryByMonth(principal, locale, DateTime.now().getYear(), DateTime.now().getMonthOfYear());
	}

	/**
	 * Retourne la première page du détail d'un compte pour un mois donné
	 * 
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping(value = "{year:20\\d{2}}/{month:[1-9]|1[012]}/history.html", method = RequestMethod.GET)
	public ModelAndView virementHistoryByMonth(Principal principal, Locale locale, @PathVariable int year,
			@PathVariable int month) {
		return virementHistoryByMonthAndPage(principal, locale, year, month, 0);
	}

	/**
	 * Retourne le détail d'un compte pour un mois donné et pour une page donnée
	 * 
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @param year
	 * @param month
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{year}/{month:[1-9]|1[012]}/{page:[0-9]+}/history.html", method = RequestMethod.GET)
	public ModelAndView virementHistoryByMonthAndPage(Principal principal, Locale locale, @PathVariable int year,
			@PathVariable int month, @PathVariable int page) {
		// Vérifie que le mois demandé existe, que la page demandée existe.
		if (!monthInHistory(month, year) || !pageExist(principal.getName(), year, month, page)) {
			throw new ResourceNotFoundException();
		}
		ModelAndView mv = new ModelAndView("detailCompte");
		YearMonth currentMonth = new YearMonth(year, month);
		long nbPages = operationService.getNumberOfPagesForVirementByMonth(principal.getName(), month, year);
		// Ajout de la date courrante dans le modèle
		DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM yyyy");
		DateTimeFormatter localeFmt = fmt.withLocale(locale);
		mv.addObject("currentDate", localeFmt.print(currentMonth));
		// Ajout du nombre de page du détail dans le modèle
		mv.addObject("numPageMonth", nbPages);
		// Ajout des urls pour aller sur les différentes pages du détails
		mv.addObject("mapUrlPages", getPagesUrls(currentMonth.getYear(), currentMonth.getMonthOfYear(), nbPages));
		// Ajout du numéro de la page courrante dans le modèle
		mv.addObject("currentPage", page);
		// Ajout de l'url pour aller dans les différents mois de l'historique dans le modèle
		mv.addObject("mapNamesUrlsForMonths", getMonthUrls(locale));
		// Ajout des opérations dans le modèle
		mv.addObject("virements", operationService.getVirementsByMonthPaginated(principal.getName(), month, year, page));
		// Ajout de des urls pour aller au mois suivant et précédent dans le modèle si ils existent
		if (hasPreviousMonth(month, year)) {
			YearMonth monthBefore = currentMonth.minusMonths(1);
			mv.addObject("urlPreviousMonth", LinkBuilder.getLink("client", "virement", monthBefore.getYear(),
					monthBefore.getMonthOfYear(), "history.html"));
		}
		if (hasNextMonth(month, year)) {
			YearMonth monthBefore = currentMonth.plusMonths(1);
			mv.addObject("urlNextMonth", LinkBuilder.getLink("client", "virement", monthBefore.getYear(),
					monthBefore.getMonthOfYear(), "history.html"));
		}
		return mv;
	}

	/**
	 * Vérifie si il y a un mois précédent dans l'historique
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	private boolean hasPreviousMonth(int month, int year) {
		boolean result = false;
		YearMonth currentMonth = new YearMonth(year, month);
		if (currentMonth.plusMonths(NB_MONTH_HISTORY - 1).isAfter(YearMonth.now())) {
			result = true;
		}
		return result;
	}

	/**
	 * Vérifie si il y a un mois précédent dans l'historique
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	private boolean hasNextMonth(int month, int year) {
		boolean result = false;
		YearMonth currentMonth = new YearMonth(year, month);
		if (currentMonth.isBefore(YearMonth.now())) {
			result = true;
		}
		return result;
	}

	/**
	 * Vérifie si un mois et bien dans l'historique
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	private boolean monthInHistory(int month, int year) {
		boolean result = false;
		YearMonth currentMonth = new YearMonth(year, month);
		if (currentMonth.plusMonths(NB_MONTH_HISTORY).isAfter(YearMonth.now())
				&& (currentMonth.isBefore(YearMonth.now()) || currentMonth.isEqual(YearMonth.now()))) {
			result = true;
		}
		return result;
	}

	/**
	 * Vérifie qu'une page existe bien dans l'historique
	 * 
	 * @param idCompte
	 * @param year
	 * @param month
	 * @param page
	 * @param cardDetail
	 *            vrai si détail opération carte, faux sinon
	 * @return
	 */
	private boolean pageExist(String username, int year, int month, int page) {
		return 0L <= page && page <= operationService.getNumberOfPagesForVirementByMonth(username, month, year);
	}

	/**
	 * Créer les URLs pour aller dans les différentes pages du détail
	 * 
	 * @param idCompte
	 * @param year
	 * @param month
	 * @param nbPages
	 * @param cardDetail
	 *            vrai si détail opération carte, faux sinon
	 * @return
	 */
	private Map<Long, String> getPagesUrls(int year, int month, long nbPages) {
		Map<Long, String> map = new LinkedHashMap<Long, String>();
		for (long indexPage = 0; indexPage < nbPages; indexPage++) {
			map.put(indexPage, LinkBuilder.getLink("client", "virement", year, month, indexPage, "history.html"));
		}
		return map;
	}

	/**
	 * Créer les URLs pour aller dans les différents mois de l'historique
	 * 
	 * @param locale
	 * @param idCompte
	 * @param cardDetail
	 *            vrai si détail opération carte, faux sinon
	 * @return
	 */
	private Map<String, String> getMonthUrls(Locale locale) {
		Map<String, String> mapNamesUrls = new LinkedHashMap<String, String>();
		YearMonth now = YearMonth.now();
		// DateTime now = DateTime.now();
		for (int i = 0; i <= 5; i++) {
			// DateTime month = now.minusMonths(i);
			YearMonth month = now.minusMonths(i);
			DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM yyyy");
			DateTimeFormatter localeFmt = fmt.withLocale(locale);
			mapNamesUrls.put(localeFmt.print(month),
					LinkBuilder.getLink("client", "virement", month.getYear(), month.getMonthOfYear(), "history.html"));
		}
		return mapNamesUrls;
	}
}
