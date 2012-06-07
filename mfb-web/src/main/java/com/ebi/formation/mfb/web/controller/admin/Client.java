package com.ebi.formation.mfb.web.controller.admin;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.web.forms.admin.ClientForm;

/**
 * Controller permettant de gérer un client
 * 
 * @author fguillain
 * 
 */
@Controller
@RequestMapping("/admin")
public class Client {

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
			BindingResult result) {
		ModelAndView mv = new ModelAndView("admin");
		String[] tabClassActive = { "active", "", "" };
		mv.addObject("classActive", tabClassActive);
		boolean isPasswordIdentiques = clientForm.getPassword().equals(clientForm.getPassword2());
		if (result.hasErrors() || !isPasswordIdentiques) {
			if (!isPasswordIdentiques) {
				result.addError(new FieldError("clientForm", "password2", null, true,
						new String[] { "admin.clientForm.passwordNotSame" }, null, null));
			}
			mv.setViewName("createClient");
		}
		return mv;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "createClient.html")
	public ModelAndView createClientForm() {
		ModelAndView mv = new ModelAndView("createClient");
		String[] tabClassActive = { "active", "", "" };
		mv.addObject("classActive", tabClassActive);
		mv.addObject(new ClientForm());
		return mv;
	}
}
