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
import com.ebi.formation.mfb.services.IOperationService;
import com.ebi.formation.mfb.services.impl.OperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.web.forms.VirementInterneForm;

@Controller
@RequestMapping("/client/")
public class Virement {

	@Autowired
	ICompteService compteService;
	@Autowired
	IOperationService operationService;

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
				result.addError(new FieldError("virementInterneForm", "compteADebiter", null, true,
						new String[] { "virementInterneForm.comptesIdentiques" }, null, null));
			}
			mv.setViewName("virementInterne");
			return mv;
		}
		ReturnCodeVirement returnCode = operationService.doVirement(virementInterneForm.getCompteADebiter(),
				virementInterneForm.getCompteACrediter(), virementInterneForm.getMotif(),
				virementInterneForm.getMontant());
		mv.setViewName("confirmVirement");
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
				mv.addObject("isOK", new Object());
				break;
		}
		mv.addObject("message", message);
		return mv;
	}
}
