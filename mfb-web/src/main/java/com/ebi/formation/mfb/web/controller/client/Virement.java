package com.ebi.formation.mfb.web.controller.client;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.services.IOperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.web.forms.VirementExterneForm;
import com.ebi.formation.mfb.web.forms.VirementInterneForm;
import com.ebi.formation.mfb.web.utils.ControllerUtils;

@Controller
@RequestMapping("/client/")
public class Virement {

	@Autowired
	private ICompteService compteService;
	@Autowired
	private IOperationService operationService;

	/**
	 * Affiche le formulaire permettant de saisir un virement
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "virementInterne.html")
	public ModelAndView virementInterneForm(Principal principal) {
		ModelAndView mv = new ModelAndView("virementInterne");
		mv.addObject("comptesList", compteService.findComptesByUsername(principal.getName()));
		mv.addObject(new VirementInterneForm());
		return mv;
	}

	/**
	 * Affiche le formulaire permettant de saisir un virement externe
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "virementExterne.html")
	public ModelAndView virementExterneForm(Principal principal) {
		ModelAndView mv = new ModelAndView("virementExterne");
		mv.addObject("comptesList", compteService.findComptesByUsername(principal.getName()));
		mv.addObject(new VirementExterneForm());
		return mv;
	}

	/**
	 * Traite les erreurs du formulaire du virement et affiche la page de confirmation du virement
	 * 
	 * @param principal
	 * @param virementInterneForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "doVirementInterne.html", method = RequestMethod.POST)
	public ModelAndView doVirementInterne(Principal principal,
			@ModelAttribute @Valid VirementInterneForm virementInterneForm, BindingResult result,
			RedirectAttributes redirectAttrs) {
		ModelAndView mv = new ModelAndView();
		boolean isCompteIdentiques = virementInterneForm.getCompteACrediter().equals(
				virementInterneForm.getCompteADebiter());
		if (result.hasErrors() || isCompteIdentiques) {
			mv.addObject("comptesList", compteService.findComptesByUsername(principal.getName()));
			if (isCompteIdentiques) {
				result.addError(new FieldError("virementInterneForm", "compteACrediter", null, true,
						new String[] { "virementInterneForm.comptesIdentiques" }, null, null));
			}
			mv.setViewName("virementInterne");
			return mv;
		}
		ReturnCodeVirement returnCode = operationService.doVirement(virementInterneForm.getCompteADebiter(),
				virementInterneForm.getCompteACrediter(), StringUtils.trimToNull(virementInterneForm.getMotif()),
				virementInterneForm.getMontant());
		mv.setViewName("redirect:erreurVirement.html");
		String message = null;
		switch (returnCode) {
			case COMPTE_CREDIT_INEXISTANT:
				message = "virement.noCompteCredit";
				break;
			case COMPTE_DEBIT_INEXISTANT:
				message = "virement.noCompteDebit";
				break;
			case DECOUVERT:
				message = "virement.decouvert";
				break;
			case OK:
				message = "virement.ok";
				mv.setViewName("redirect:confirmVirement.html");
				break;
			default:
				break;
		}
		redirectAttrs.addFlashAttribute("message", message);
		return mv;
	}

	/**
	 * Bugfix du changement de locale sur la page doVirement.html
	 * 
	 * @return
	 */
	@RequestMapping(value = "doVirementInterne.html", method = RequestMethod.GET)
	public ModelAndView doVirementInterne() {
		return new ModelAndView("redirect:virementInterne.html");
	}

	/**
	 * Bugfix du changement de locale sur la page doVirementExterne.html
	 * 
	 * @return
	 */
	@RequestMapping(value = "doVirementExterne.html", method = RequestMethod.GET)
	public ModelAndView doVirementExterne() {
		return new ModelAndView("redirect:virementExterne.html");
	}

	/**
	 * Traite les erreurs du formulaire du virement et affiche la page de confirmation du virement
	 * 
	 * @param principal
	 * @param virementInterneForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "doVirementExterne.html", method = RequestMethod.POST)
	public ModelAndView doVirementExterne(Principal principal,
			@ModelAttribute @Valid VirementExterneForm virementInterneForm, BindingResult result,
			RedirectAttributes redirectAttrs) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.addObject("comptesList", compteService.findComptesByUsername(principal.getName()));
			mv.setViewName("virementExterne");
			return mv;
		}
		ReturnCodeVirement returnCode = operationService.doVirement(virementInterneForm.getCompteADebiter(),
				virementInterneForm.getNumeroCompteACrediter(), StringUtils.trimToNull(virementInterneForm.getMotif()),
				virementInterneForm.getMontant());
		mv.setViewName("redirect:erreurVirement.html");
		String message = null;
		switch (returnCode) {
			case COMPTE_CREDIT_INEXISTANT:
				message = "virement.noCompteCredit";
				break;
			case COMPTE_DEBIT_INEXISTANT:
				message = "virement.noCompteDebit";
				break;
			case DECOUVERT:
				message = "virement.decouvert";
				break;
			case OK:
				message = "virement.ok";
				mv.setViewName("redirect:confirmVirement.html");
				break;
			default:
				break;
		}
		redirectAttrs.addFlashAttribute("message", message);
		return mv;
	}

	/**
	 * Affiche la page confirmant que le virement a bien été effectué
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "confirmVirement.html", method = RequestMethod.GET)
	public ModelAndView confirmVirement(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "confirmVirement", "/client/home.html");
	}

	/**
	 * Affiche la page confirmant que le virement n'a pas pu être effectué
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "erreurVirement.html", method = RequestMethod.GET)
	public ModelAndView erreurVirement(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "erreurVirement", "/client/home.html");
	}
}
