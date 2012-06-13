package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService;

/**
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService")
public class CompteWebService implements ICompteWebService {

	@Autowired
	private ICompteService compteService;
	@Autowired
	private DTOBinder binder;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService#findComptesByUsername(java.lang.String)
	 */
	@Override
	public List<CompteDTO> findComptesByUsername(String username) {
		return binder.bindFromBusinessObjectList(CompteDTO.class, compteService.findComptesByUsername(username));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService#checkCompteOwnershipByUsernameAndCompteId(java.lang
	 * .String, java.lang.Long)
	 */
	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService#getCompteById(java.lang.Long)
	 */
	@Override
	public CompteDTO getCompteById(Long compteId) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteById(compteId));
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService#getCompteByNumeroCompte(java.lang.String)
	 */
	@Override
	public CompteDTO getCompteByNumeroCompte(String numeroCompte) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteByNumeroCompte(numeroCompte));
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService#save(java.lang.String, java.lang.String,
	 * java.math.BigDecimal)
	 */
	@Override
	public Object[] save(String libelle, String usernamePerson, BigDecimal solde) {
		return compteService.save(libelle, usernamePerson, solde);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService#findAllComptes()
	 */
	@Override
	public List<CompteDTO> findAllComptes() {
		return binder.bindFromBusinessObjectList(CompteDTO.class, compteService.findAllComptes());
	}
}
