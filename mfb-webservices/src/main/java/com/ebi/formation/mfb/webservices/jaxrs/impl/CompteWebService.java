package com.ebi.formation.mfb.webservices.jaxrs.impl;

import java.util.List;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;
import com.ebi.formation.mfb.webservicesapi.jaxrs.ICompteWebService;

/**
 * Implémentation de {@link ICompteWebService}
 * 
 * @author excilys
 * 
 */
public class CompteWebService implements ICompteWebService {

	@Autowired
	private ICompteService compteService;
	@Autowired
	private DTOBinder binder;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxrs.ICompteWebService#getCompteById(java.lang.Long)
	 */
	@Override
	public CompteDTO getCompteById(Long compteId) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteById(compteId));
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxrs.ICompteWebService#findComptesByUsername(java.lang.String)
	 */
	@Override
	public List<CompteDTO> findComptesByUsername(String username) {
		return binder.bindFromBusinessObjectList(CompteDTO.class, compteService.findComptesByUsername(username));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.webservicesapi.jaxrs.ICompteWebService#checkCompteOwnershipByUsernameAndCompteId(java.lang
	 * .String, java.lang.Long)
	 */
	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxrs.ICompteWebService#getCompteByNumeroCompte(java.lang.String)
	 */
	@Override
	public CompteDTO getCompteByNumeroCompte(String numeroCompte) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteByNumeroCompte(numeroCompte));
	}
}