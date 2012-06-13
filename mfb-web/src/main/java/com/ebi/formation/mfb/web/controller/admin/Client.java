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

import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.services.IPersonService.ReturnCodePerson;
import com.ebi.formation.mfb.services.IRoleService;
import com.ebi.formation.mfb.web.controller.Admin;
import com.ebi.formation.mfb.web.forms.admin.ClientForm;
import com.ebi.formation.mfb.web.utils.ControllerUtils;
import com.ebi.formation.mfb.web.utils.SessionAttributesNames;

/**
 * Controller permettant de gérer un client
 * 
 * @author fguillain
 * 
 */
@Controller
@RequestMapping("/admin")
public class Client {

	@Autowired
	private IPersonService personService;
	@Autowired
	private IRoleService roleService;
	private static final String OBJECT_LIST_RIGHTS = "listRights";

	/**
	 * 
	 * 
	 * @param principal
	 * @param clientForm
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "doCreateClient.html", method = RequestMethod.POST)
	public ModelAndView doCreateClient(Principal principal, @ModelAttribute @Valid ClientForm clientForm,
			BindingResult result, RedirectAttributes redirectAttrs) {
		ModelAndView mv = new ModelAndView();
		boolean isPasswordIdentiques = clientForm.getPassword().equals(clientForm.getPassword2());
		if (result.hasErrors() || !isPasswordIdentiques) {
			if (!isPasswordIdentiques) {
				result.addError(new FieldError("clientForm", "password2", null, true,
						new String[] { "admin.clientForm.passwordNotSame" }, null, null));
			}
			mv.addObject(OBJECT_LIST_RIGHTS, roleService.findAllRights());
			mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(0));
			mv.setViewName("createClient");
			return mv;
		}
		ReturnCodePerson returnCode = personService.save(clientForm.getUsername(), clientForm.getFirstname(),
				clientForm.getLastname(), clientForm.getPassword(), clientForm.getListRights());
		String message = null;
		mv.setViewName("redirect:erreurCreateClient.html");
		switch (returnCode) {
			case OK:
				message = "admin.createClientForm.ok";
				redirectAttrs.addFlashAttribute("infoPlus", clientForm.getUsername());
				mv.setViewName("redirect:confirmCreateClient.html");
				break;
			case IDENTICAL_USERNAME:
				message = "admin.createClientForm.identicalUsername";
				break;
			case ROLES_NOT_DEFINED:
				message = "admin.createClientForm.error";
			default:
				break;
		}
		redirectAttrs.addFlashAttribute("message", message);
		return mv;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "createClient.html")
	public ModelAndView createClientForm() {
		ModelAndView mv = new ModelAndView("createClient");
		mv.addObject(OBJECT_LIST_RIGHTS, roleService.findAllRights());
		mv.addObject(SessionAttributesNames.CLASS_ACTIVE, Admin.getClassActive(0));
		mv.addObject(new ClientForm());
		return mv;
	}

	/**
	 * Bugfix du changement de locale sur la page doCreateOperation.html
	 * 
	 * @return
	 */
	@RequestMapping(value = "doCreateClient.html", method = RequestMethod.GET)
	public ModelAndView doCreateOperationForm() {
		return new ModelAndView("redirect:createClient.html");
	}

	/**
	 * Affiche la page confirmant que le client a bien été créé
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "confirmCreateClient.html", method = RequestMethod.GET)
	public ModelAndView confirmCreateClient(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "confirmForm", "/admin/home.html");
	}

	/**
	 * Affiche la page confirmant que le client n'a pas pu être créé
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "erreurCreateClient.html", method = RequestMethod.GET)
	public ModelAndView erreurCreateClient(HttpServletRequest request) {
		return ControllerUtils.redirectPageInfoOrHome(request, "erreurForm", "/admin/home.html");
	}
}
