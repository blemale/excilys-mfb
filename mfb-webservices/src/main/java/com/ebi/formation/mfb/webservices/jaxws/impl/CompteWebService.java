package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService;

@WebService(endpointInterface = "com.ebi.formation.mfb.webservicesapi.jaxws.ICompteWebService")
public class CompteWebService implements ICompteWebService {

	@Autowired
	private ICompteService compteService;

	@Override
	public List<CompteDTO> findComptesByUsername(String username) {
		return convertListCompteToListCompteDTO(compteService.findComptesByUsername(username));
	}

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	@Override
	public CompteDTO getCompteById(Long compteId) {
		return convertCompteToCompteDTO(compteService.getCompteById(compteId));
	}

	@Override
	public CompteDTO getCompteByNumeroCompte(String numeroCompte) {
		return convertCompteToCompteDTO(compteService.getCompteByNumeroCompte(numeroCompte));
	}

	@Override
	public Object[] save(String libelle, String usernamePerson, BigDecimal solde) {
		return compteService.save(libelle, usernamePerson, solde);
	}

	private CompteDTO convertCompteToCompteDTO(Compte compte) {
		return new CompteDTO(compte.getId(), compte.getLabel(), compte.getSolde(), compte.getSoldePrevisionnel(),
				compte.getEncoursCarte(), compte.getNumeroCompte());
	}

	private List<CompteDTO> convertListCompteToListCompteDTO(List<Compte> comptes) {
		List<CompteDTO> compteDTOs = new ArrayList<CompteDTO>();
		for (Compte c : comptes) {
			compteDTOs.add(convertCompteToCompteDTO(c));
		}
		return compteDTOs;
	}
}
