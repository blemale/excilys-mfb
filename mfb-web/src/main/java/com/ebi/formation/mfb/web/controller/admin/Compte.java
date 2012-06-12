package com.ebi.formation.mfb.web.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.web.controller.Admin;
import com.ebi.formation.mfb.web.forms.admin.CompteForm;
import com.ebi.formation.mfb.web.utils.ControllerUtils;
import com.ebi.formation.mfb.web.utils.SessionAttributesNames;

/**
 * Controller permettant de gérer un compte
 * 
 * @author fguillain
 * 
 */
@Controller
@RequestMapping("/admin")
public class Compte {

	@Autowired
	private ICompteService compteService;
	@Autowired
	private IPersonService personService;
	private static final String OBJECT_LIST_OWNERS = "listOwners";

	/**
	 * @param principal
	 * @param compteForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "doCreateCompte.html", method = RequestMethod.POST)
	public ModelAndView doCreateCompte(Principal principal, @ModelAttribute @Valid CompteForm compteForm,
			BindingResult result, RedirectAttributes redirectAttrs) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.addObject(OBJECT_LIST_OWNERS, personService.findAllPersons());
			mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(1));
			mv.setViewName("createCompte");
			return mv;
		}
		Object[] res = compteService.save(compteForm.getLabel(), compteForm.getUsernameOwner(), compteForm.getSolde());
		mv.setViewName("redirect:erreurCreateCompte.html");
		String message = null;
		switch (res.length) {
			case 1:
				message = "admin.createCompteForm.noOwner";
				break;
			case 2:
				message = "admin.createCompteForm.ok";
				// res[1] = numéro du compte
				redirectAttrs.addFlashAttribute("infoPlus", res[1].toString());
				mv.setViewName("redirect:confirmCreateCompte.html");
				break;
			default:
				break;
		}
		redirectAttrs.addFlashAttribute("message", message);
		return mv;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "createCompte.html")
	public ModelAndView createCompteForm() {
		ModelAndView mv = new ModelAndView("createCompte");
		mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(1));
		mv.addObject(OBJECT_LIST_OWNERS, personService.findAllPersons());
		mv.addObject(new CompteForm());
		return mv;
	}

	/**
	 * Bugfix du changement de locale sur la page doCreateOperation.html
	 * 
	 * @return
	 */
	@RequestMapping(value = "doCreateCompte.html", method = RequestMethod.GET)
	public ModelAndView doCreateOperationForm() {
		return new ModelAndView("redirect:createCompte.html");
	}

	/**
	 * Affiche la page confirmant que le compte a bien été créé
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "confirmCreateCompte.html", method = RequestMethod.GET)
	public ModelAndView confirmCreateClient(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "confirmForm", "/admin/home.html");
	}

	/**
	 * Affiche la page confirmant que le compte n'a pas pu être créé
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "erreurCreateCompte.html", method = RequestMethod.GET)
	public ModelAndView erreurCreateClient(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "erreurForm", "/admin/home.html");
	}
}
