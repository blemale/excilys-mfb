package com.ebi.formation.mfb.web.controller.admin;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.services.IOperationTypeService;
import com.ebi.formation.mfb.web.controller.Admin;
import com.ebi.formation.mfb.web.forms.admin.OperationForm;
import com.ebi.formation.mfb.web.utils.SessionAttributesNames;

/**
 * Controller permettant de gérer une opération
 * 
 * @author fguillain
 * 
 */
@Controller
@RequestMapping("/admin")
public class Operation {

	@Autowired
	private IOperationTypeService operationTypeService;
	@Autowired
	private ICompteService compteService;

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
		mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(2));
		if (result.hasErrors()) {
			mv.addObject("comptesList", compteService.findAllComptes());
			mv.addObject("typesList", operationTypeService.findAllOperationTypes());
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
		mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(2));
		mv.addObject("comptesList", compteService.findAllComptes());
		mv.addObject("typesList", operationTypeService.findAllOperationTypes());
		mv.addObject(new OperationForm());
		return mv;
	}

	/**
	 * Bugfix du changement de locale sur la page doCreateOperation.html
	 * 
	 * @return
	 */
	@RequestMapping(value = "doCreateOperation.html", method = RequestMethod.GET)
	public ModelAndView doCreateOperationForm() {
		return new ModelAndView("redirect:createOperation.html");
	}
}
