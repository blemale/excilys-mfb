package com.ebi.formation.mfb.web.controller.client;

import java.io.IOException;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.web.exception.ResourceNotFoundException;
import com.ebi.formation.mfb.web.utils.ExcelGenerator;
import com.ebi.formation.mfb.web.utils.LinkBuilder;

/**
 * Controller gérant l'accès au détail des comptes et des opérations cartes.
 * 
 * @author excilys
 * 
 */
@Controller
@RequestMapping("/client/compte/{idCompte:\\d+}/")
public class Detail {

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
	@RequestMapping(value = "detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompte(Principal principal, Locale locale, @PathVariable Long idCompte) {
		return detailCompteMois(principal, locale, idCompte, DateTime.now().getYear(), DateTime.now().getMonthOfYear());
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
	@RequestMapping(value = "{year:20\\d{2}}/{month:[1-9]|1[012]}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteMois(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month) {
		return detailCompteMoisAndPage(principal, locale, idCompte, year, month, 0);
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
	@RequestMapping(value = "{year}/{month:[1-9]|1[012]}/{page:[0-9]+}/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteMoisAndPage(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month, @PathVariable int page) {
		// Vérifie que le compte appartient au user connecté, que le mois demandé existe, que la page demandée existe.
		if (!compteService.checkCompteOwnershipByUsernameAndCompteId(principal.getName(), idCompte)
				|| !monthInHistory(month, year) || !pageExist(idCompte, year, month, page, false)) {
			throw new ResourceNotFoundException();
		}
		ModelAndView mv = new ModelAndView("detailCompte");
		YearMonth currentMonth = new YearMonth(year, month);
		long nbPages = operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
		addToModelCommonObjects(mv, locale, idCompte, currentMonth, page, nbPages, false);
		// Ajout des opérations dans le modèle
		mv.addObject("operations",
				operationService.getOperationsWithoutCarteByMonthPaginated(idCompte, month, year, page));
		// Ajout du solde carte dans le modèle
		mv.addObject("soldeCarte", operationService.getTotalOperationsCarteByMonth(idCompte, month, year));
		// Ajout de des urls pour aller au mois suivant et précédent dans le modèle si ils existent
		if (hasPreviousMonth(month, year)) {
			YearMonth monthBefore = currentMonth.minusMonths(1);
			mv.addObject(
					"urlPreviousMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "detail.html"));
		}
		if (hasNextMonth(month, year)) {
			YearMonth monthBefore = currentMonth.plusMonths(1);
			mv.addObject(
					"urlNextMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "detail.html"));
		}
		mv.addObject("urlDetailCarte",
				LinkBuilder.getLink("client", "compte", idCompte, year, month, "carte", "detail.html"));
		return mv;
	}

	/**
	 * Retourne la première page du détail des opérations cartes pour le mois en cours.
	 * 
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @return
	 */
	@RequestMapping(value = "carte/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteCarte(Principal principal, Locale locale, @PathVariable Long idCompte) {
		return detailCompteCarteMois(principal, locale, idCompte, DateTime.now().getYear(), DateTime.now()
				.getMonthOfYear());
	}

	/**
	 * Retourne la première page du détail des opérations cartes pour un mois donné.
	 * 
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @param year
	 * @param month
	 * @return
	 */
	@RequestMapping(value = "{year:20\\d{2}}/{month:[1-9]|1[012]}/carte/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteCarteMois(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month) {
		return detailCompteCarteMoisAndPage(principal, locale, idCompte, year, month, 0);
	}

	/**
	 * Retourne le détail des opérations cartes pour un mois donné et une page donnée.
	 * 
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @param year
	 * @param month
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{year}/{month:[1-9]|1[012]}/{page:[0-9]+}/carte/detail.html", method = RequestMethod.GET)
	public ModelAndView detailCompteCarteMoisAndPage(Principal principal, Locale locale, @PathVariable Long idCompte,
			@PathVariable int year, @PathVariable int month, @PathVariable int page) {
		if (!compteService.checkCompteOwnershipByUsernameAndCompteId(principal.getName(), idCompte)
				|| !monthInHistory(month, year) || !pageExist(idCompte, year, month, page, true)) {
			throw new ResourceNotFoundException();
		}
		ModelAndView mv = new ModelAndView("detailCompteCarte");
		long nbPages = operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
		YearMonth currentMonth = new YearMonth(year, month);
		addToModelCommonObjects(mv, locale, idCompte, currentMonth, page, nbPages, true);
		// Ajout des opérations carte dans le modèle
		mv.addObject("operations", operationService.getOperationsCarteByMonthPaginated(idCompte, month, year, page));
		// Ajout de des urls pour aller au mois suivant et précédent dans le modèle si ils existent
		if (hasPreviousMonth(month, year)) {
			YearMonth monthBefore = currentMonth.minusMonths(1);
			mv.addObject(
					"urlPreviousMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "carte", "detail.html"));
		}
		if (hasNextMonth(month, year)) {
			YearMonth monthBefore = currentMonth.plusMonths(1);
			mv.addObject(
					"urlNextMonth",
					LinkBuilder.getLink("client", "compte", idCompte.longValue(), monthBefore.getYear(),
							monthBefore.getMonthOfYear(), "carte", "detail.html"));
		}
		// Ajout de l'url pour revenir au détail du compte dans le modèle
		mv.addObject("urlDetailCompte", LinkBuilder.getLink("client", "compte", idCompte, year, month, "detail.html"));
		return mv;
	}

	/**
	 * Retourne une feuille excel générée.
	 * 
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @return
	 */
	@RequestMapping(value = "{year}/{month:[1-9]|1[012]}/export.html", method = RequestMethod.GET)
	public ModelAndView exportExcel(HttpServletRequest request, HttpServletResponse response, Principal principal,
			Locale locale, @PathVariable Long idCompte, @PathVariable int year, @PathVariable int month) {
		String nomCompte = compteService.getCompteById(idCompte).getLabel();
		List<Operation> listeOperations = operationService.getAllOperationsByMonthByCompte(idCompte, month, year);
		Workbook wb = ExcelGenerator.getWorkBook(nomCompte, month, year, listeOperations);
		/****/
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=\"compte_" + idCompte + "(" + year + "-"
				+ month + ")" + ".xls\"");
		try {
			wb.write(response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retourne une feuille excel générée.
	 * 
	 * @param request
	 * @param response
	 * @param principal
	 * @param locale
	 * @param idCompte
	 * @return
	 */
	@RequestMapping(value = "export.html", method = RequestMethod.GET)
	public ModelAndView exportExcel(HttpServletRequest request, HttpServletResponse response, Principal principal,
			Locale locale, @PathVariable Long idCompte) {
		int month = DateTime.now().getMonthOfYear();
		int year = DateTime.now().getYear();
		return exportExcel(request, response, principal, locale, idCompte, year, month);
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
		// DateTime currentMonth = new DateTime(year, month, 1, 0, 0);
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
		// DateTime currentMonth = new DateTime(year, month, 1, 0, 0);
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
		// DateTime currentMonth = new DateTime(year, month, 1, 0, 0);
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
	private boolean pageExist(Long idCompte, int year, int month, int page, boolean cardDetail) {
		if (cardDetail) {
			return 0L <= page
					&& page <= operationService.getNumberOfPagesForOperationsCartesByMonth(idCompte, month, year);
		} else {
			return 0L <= page
					&& page <= operationService
							.getNumberOfPagesForOperationsWithoutCartesByMonth(idCompte, month, year);
		}
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
	private Map<Long, String> getPagesUrls(Long idCompte, int year, int month, long nbPages, boolean cardDetail) {
		Map<Long, String> map = new LinkedHashMap<Long, String>();
		for (long indexPage = 0; indexPage < nbPages; indexPage++) {
			if (cardDetail) {
				map.put(indexPage, LinkBuilder.getLink("client", "compte", idCompte, year, month, indexPage, "carte",
						"detail.html"));
			} else {
				map.put(indexPage,
						LinkBuilder.getLink("client", "compte", idCompte, year, month, indexPage, "detail.html"));
			}
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
	private Map<String, String> getMonthUrls(Locale locale, Long idCompte, boolean cardDetail) {
		Map<String, String> mapNamesUrls = new LinkedHashMap<String, String>();
		YearMonth now = YearMonth.now();
		// DateTime now = DateTime.now();
		for (int i = 0; i <= 5; i++) {
			// DateTime month = now.minusMonths(i);
			YearMonth month = now.minusMonths(i);
			DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM yyyy");
			DateTimeFormatter localeFmt = fmt.withLocale(locale);
			if (cardDetail) {
				mapNamesUrls.put(localeFmt.print(month), LinkBuilder.getLink("client", "compte", idCompte,
						month.getYear(), month.getMonthOfYear(), "carte", "detail.html"));
			} else {
				mapNamesUrls.put(localeFmt.print(month), LinkBuilder.getLink("client", "compte", idCompte,
						month.getYear(), month.getMonthOfYear(), "detail.html"));
			}
		}
		return mapNamesUrls;
	}

	/**
	 * Ajout au {@link Model} des objets communs au détail compte et détail carte.
	 * 
	 * @param mv
	 * @param locale
	 * @param idCompte
	 * @param currentMonth
	 * @param page
	 * @param nbPages
	 * @param cardDetail
	 */
	private void addToModelCommonObjects(ModelAndView mv, Locale locale, Long idCompte, YearMonth currentMonth,
			int page, long nbPages, boolean cardDetail) {
		// Ajout du compte courrant dans le modèle
		mv.addObject("compte", compteService.getCompteById(idCompte));
		// Ajout de la date courrante dans le modèle
		DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM yyyy");
		DateTimeFormatter localeFmt = fmt.withLocale(locale);
		mv.addObject("currentDate", localeFmt.print(currentMonth));
		// Ajout du nombre de page du détail dans le modèle
		mv.addObject("numPageMonth", nbPages);
		// Ajout des urls pour aller sur les différentes pages du détails
		mv.addObject("mapUrlPages",
				getPagesUrls(idCompte, currentMonth.getYear(), currentMonth.getMonthOfYear(), nbPages, cardDetail));
		// Ajout du numéro de la page courrante dans le modèle
		mv.addObject("currentPage", page);
		// Ajout de l'url pour aller dans les différents mois de l'historique dans le modèle
		mv.addObject("mapNamesUrlsForMonths", getMonthUrls(locale, idCompte, cardDetail));
	}
}
