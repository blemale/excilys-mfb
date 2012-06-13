package com.ebi.formation.mfb.web.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import com.ebi.formation.mfb.services.IOperationService.ReturnCodeOperation;
import com.ebi.formation.mfb.services.IOperationTypeService;
import com.ebi.formation.mfb.web.controller.Admin;
import com.ebi.formation.mfb.web.forms.admin.OperationForm;
import com.ebi.formation.mfb.web.utils.ControllerUtils;
import com.ebi.formation.mfb.web.utils.DateTimeUtils;
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
	private IOperationService operationService;
	@Autowired
	private IOperationTypeService operationTypeService;
	@Autowired
	private ICompteService compteService;
	private static final String OBJECT_LIST_COMPTES = "listComptes";
	private static final String OBJECT_LIST_TYPES = "listTypes";

	/**
	 * @param principal
	 * @param operationForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "doCreateOperation.html", method = RequestMethod.POST)
	public ModelAndView doCreateOperationForm(Principal principal, @ModelAttribute @Valid OperationForm operationForm,
			BindingResult result, RedirectAttributes redirectAttrs) {
		ModelAndView mv = new ModelAndView();
		boolean isDatesDifferentes = operationForm.getDateEffet().isBefore(operationForm.getDateValeur());
		boolean isDatesEgales = operationForm.getDateEffet().equals(operationForm.getDateValeur());
		if (result.hasErrors()) {
			if (!isDatesDifferentes && !isDatesEgales) {
				result.addError(new FieldError("operationForm", "dateValeur", null, true,
						new String[] { "admin.operationForm.dateValeurError" }, null, null));
			}
			mv.addObject(OBJECT_LIST_COMPTES, compteService.findAllComptes());
			mv.addObject(OBJECT_LIST_TYPES, operationTypeService.findAllOperationTypes());
			mv.addObject(DateTimeUtils.OBJECT_DATES_VALEUR, DateTimeUtils.getDates());
			mv.addObject(DateTimeUtils.OBJECT_DATES_EFFET, DateTimeUtils.getDates());
			mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(2));
			mv.setViewName("createOperation");
			return mv;
		}
		ReturnCodeOperation returnCode = operationService.saveOperation(operationForm.getMontant(),
				operationForm.getIdCompte(), operationForm.getType(), operationForm.getLabel(),
				operationForm.getDateEffet(), operationForm.getDateValeur());
		String message = null;
		mv.setViewName("redirect:erreurCreateOperation.html");
		switch (returnCode) {
			case OK:
				message = "admin.createOperationForm.ok";
				redirectAttrs.addFlashAttribute("infoPlus", operationForm.getIdCompte());
				mv.setViewName("redirect:confirmCreateOperation.html");
				break;
			case COMPTE_INEXISTANT:
				message = "admin.createOperationForm.noCompte";
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
	@RequestMapping(value = "createOperation.html")
	public ModelAndView createOperationForm() {
		ModelAndView mv = new ModelAndView("createOperation");
		mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(2));
		mv.addObject(OBJECT_LIST_COMPTES, compteService.findAllComptes());
		mv.addObject(OBJECT_LIST_TYPES, operationTypeService.findAllOperationTypes());
		mv.addObject(DateTimeUtils.OBJECT_DATES_VALEUR, DateTimeUtils.getDates());
		mv.addObject(DateTimeUtils.OBJECT_DATES_EFFET, DateTimeUtils.getDates());
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

	/**
	 * Affiche la page confirmant que l'opération a bien été créé
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "confirmCreateOperation.html", method = RequestMethod.GET)
	public ModelAndView confirmCreateOperation(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "confirmForm", "/admin/home.html");
	}

	/**
	 * Affiche la page confirmant que l'opération n'a pas pu être créé
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "erreurCreateOperation.html", method = RequestMethod.GET)
	public ModelAndView erreurCreateOperation(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "erreurForm", "/admin/home.html");
	}
}
