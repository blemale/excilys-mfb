package com.ebi.formation.mfb.webservices.jaxrs.impl;

import java.util.List;

import javax.ws.rs.Produces;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;
import com.ebi.formation.mfb.webservicesapi.jaxrs.ICompteWebService;

@Produces({ "application/json", "text/xml" })
public class CompteWebService implements ICompteWebService {

	@Autowired
	private ICompteService compteService;
	@Autowired
	private DTOBinder binder;

	@Override
	public CompteDTO getCompteById(Long compteId) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteById(compteId));
	}

	@Override
	public List<CompteDTO> findComptesByUsername(String username) {
		return binder.bindFromBusinessObjectList(CompteDTO.class, compteService.findComptesByUsername(username));
	}

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	@Override
	public CompteDTO getCompteByNumeroCompte(String numeroCompte) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteByNumeroCompte(numeroCompte));
	}
}