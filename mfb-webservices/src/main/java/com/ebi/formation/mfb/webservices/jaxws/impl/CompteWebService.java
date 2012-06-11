package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.ICompteService;

@WebService(endpointInterface = "com.ebi.formation.mfb.webservices.jaxws.ICompteWebService")
public class CompteWebService implements ICompteService {

	@Autowired
	private ICompteService compteService;

	@Override
	public List<Compte> findComptesByUsername(String username) {
		return compteService.findComptesByUsername(username);
	}

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	@Override
	public Compte getCompteById(Long compteId) {
		return compteService.getCompteById(compteId);
	}

	@Override
	public Compte getCompteByNumeroCompte(String numeroCompte) {
		return compteService.getCompteByNumeroCompte(numeroCompte);
	}

	@Override
	public Object[] save(String libelle, String usernamePerson, BigDecimal solde) {
		return compteService.save(libelle, usernamePerson, solde);
	}
}
