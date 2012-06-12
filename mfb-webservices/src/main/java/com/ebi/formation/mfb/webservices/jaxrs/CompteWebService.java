package com.ebi.formation.mfb.webservices.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservices.dto.CompteDTO;

@Produces({ "application/json", "text/xml" })
public class CompteWebService implements ICompteWebService {

	@Autowired
	private ICompteService compteService;

	@Override
	public CompteDTO getCompteById(@PathParam("compteId") Long compteId) {
		return convertCompteToCompteDTO(compteService.getCompteById(compteId));
	}

	@Override
	public List<CompteDTO> findComptesByUsername(@PathParam("username") String username) {
		return convertListCompteToListCompteDTO(compteService.findComptesByUsername(username));
	}

	@Override
	public boolean checkCompteOwnershipByUsernameAndCompteId(@PathParam("username") String username,
			@PathParam("compteId") Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	@Override
	public CompteDTO getCompteByNumeroCompte(@PathParam("numeroCompte") String numeroCompte) {
		return convertCompteToCompteDTO(compteService.getCompteByNumeroCompte(numeroCompte));
	}

	private CompteDTO convertCompteToCompteDTO(Compte compte) {
		if (compte == null) {
			return null;
		}
		return new CompteDTO(compte.getId(), compte.getLabel(), compte.getSolde(), compte.getSoldePrevisionnel(),
				compte.getEncoursCarte(), compte.getNumeroCompte());
	}

	private List<CompteDTO> convertListCompteToListCompteDTO(List<Compte> comptes) {
		List<CompteDTO> compteDTOs = new ArrayList<CompteDTO>();
		for (Compte c : comptes) {
			if (c != null) {
				compteDTOs.add(convertCompteToCompteDTO(c));
			}
		}
		return compteDTOs;
	}
}