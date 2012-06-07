package com.ebi.formation.mfb.web.controller.admin;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.web.forms.admin.OperationForm;

/**
 * Controller permettant de gérer une opération
 * 
 * @author fguillain
 * 
 */
@Controller
@RequestMapping("/admin")
public class Operation {

	/**
	 * @param principal
	 * @param operationForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "doCreateOperation.html", method = RequestMethod.POST)
	public ModelAndView doCreateOperationForm(Principal principal, @ModelAttribute @Valid OperationForm operationForm,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("admin");
		String[] tabClassActive = { "", "", "active" };
		mv.addObject("classActive", tabClassActive);
		if (result.hasErrors()) {
			mv.addObject("comptesList", null);
			mv.addObject("typesList", null);
			mv.setViewName("createOperation");
		}
		return mv;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "createOperation.html")
	public ModelAndView createOperationForm() {
		ModelAndView mv = new ModelAndView("createOperation");
		String[] tabClassActive = { "", "", "active" };
		mv.addObject("classActive", tabClassActive);
		mv.addObject("comptesList", null);
		mv.addObject("typesList", null);
		mv.addObject(new OperationForm());
		return mv;
	}
}
