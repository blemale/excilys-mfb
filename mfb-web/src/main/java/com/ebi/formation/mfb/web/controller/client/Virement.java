package com.ebi.formation.mfb.web.controller.client;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.web.forms.VirementInterneForm;

@Controller
@RequestMapping("/client/")
public class Virement {

	@Autowired
	ICompteService compteService;

	@RequestMapping(value = "virement.html")
	public ModelAndView virementInterneForm(Principal principal) {
		ModelAndView mv = new ModelAndView("virementInterne");
		mv.addObject("comptesList", compteService.findComptesByUsername(principal.getName()));
		mv.addObject(new VirementInterneForm());
		return mv;
	}

	@RequestMapping(value = "doVirement.html", method = RequestMethod.POST)
	public ModelAndView doVirement(Principal principal, @ModelAttribute @Valid VirementInterneForm virementInterneForm,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();
		boolean isCompteIdentiques = virementInterneForm.getCompteACrediter().equals(
				virementInterneForm.getCompteADebiter());
		if (result.hasErrors() || isCompteIdentiques) {
			mv.addObject("comptesList", compteService.findComptesByUsername(principal.getName()));
			if (isCompteIdentiques) {
				result.addError(new FieldError("virementInterneForm", "compteADebiter", "Comptes identiques"));
			}
			mv.setViewName("virementInterne");
			return mv;
		}
		// TODO virement pour de vrai
		mv.setViewName("confirmVirement");
		return mv;
	}
}
