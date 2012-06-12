package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService;

@WebService(endpointInterface = "com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService")
public class CompteWebService implements ICompteWebService {

	@Autowired
	private ICompteService compteService;
	@Autowired
	private DTOBinder binder;

	@Override
	public List<CompteDTO> findComptesByUsername(String username) {
		return binder.bindFromBusinessObjectList(CompteDTO.class, compteService.findComptesByUsername(username));
	}

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	@Override
	public CompteDTO getCompteById(Long compteId) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteById(compteId));
	}

	@Override
	public CompteDTO getCompteByNumeroCompte(String numeroCompte) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteByNumeroCompte(numeroCompte));
	}

	@Override
	public Object[] save(String libelle, String usernamePerson, BigDecimal solde) {
		return compteService.save(libelle, usernamePerson, solde);
	}

	@Override
	public List<CompteDTO> findAllComptes() {
		return binder.bindFromBusinessObjectList(CompteDTO.class, compteService.findAllComptes());
	}
}
