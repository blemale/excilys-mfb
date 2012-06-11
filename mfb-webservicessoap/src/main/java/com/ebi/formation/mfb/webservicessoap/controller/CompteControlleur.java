package com.ebi.formation.mfb.webservicessoap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService;

/**
 * Classe gérant les tests liées aux WebServices du Compte
 * 
 * @author excilys
 * 
 */
@Controller
public class CompteControlleur {

	@Autowired
	private ICompteWebService compteWebService;

	/**
	 * Test de la méthode getCompteById
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCompteById.html", method = RequestMethod.GET)
	public ModelAndView testGetCompteById() {
		CompteDTO compte = compteWebService.getCompteById(2L);
		return new ModelAndView("compte/getCompteById", "compte", compte);
	}

	/**
	 * Test de la méthode findComptesByUsername
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findComptesByUsername.html", method = RequestMethod.GET)
	public ModelAndView testFindComptesByUsername() {
		List<CompteDTO> comptes = compteWebService.findComptesByUsername("user");
		return new ModelAndView("compte/findComptesByUsername", "comptes", comptes);
	}

	/**
	 * Test de la méthode checkCompteOwnershipByUsernameAndCompteId
	 * 
	 * @return
	 */
	@RequestMapping(value = "/checkCompteOwnershipByUsernameAndCompteId.html", method = RequestMethod.GET)
	public ModelAndView testCheckCompteOwnershipByUsernameAndCompteId() {
		Boolean boolUser1 = compteWebService.checkCompteOwnershipByUsernameAndCompteId("user", 1L);
		Boolean boolUser3 = compteWebService.checkCompteOwnershipByUsernameAndCompteId("user", 3L);
		Boolean boolUseradmin3 = compteWebService.checkCompteOwnershipByUsernameAndCompteId("useradmin", 3L);
		ModelAndView mv = new ModelAndView("compte/checkCompteOwnershipByUsernameAndCompteId");
		mv.addObject("boolUser1", boolUser1);
		mv.addObject("boolUser3", boolUser3);
		mv.addObject("boolUseradmin3", boolUseradmin3);
		return mv;
	}
}
