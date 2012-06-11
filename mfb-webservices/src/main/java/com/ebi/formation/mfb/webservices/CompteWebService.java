package com.ebi.formation.mfb.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservices.dto.CompteDTO;

@Service("compteWebService")
@Produces({ "application/json", "text/xml" })
public class CompteWebService {

	@Autowired
	private ICompteService compteService;

	@GET
	@Path("getCompteById/{compteId}")
	public CompteDTO getCompteById(@PathParam("compteId") Long compteId) {
		System.out.println(convertCompteToCompteDTO(compteService.getCompteById(compteId)).getLabel());
		return convertCompteToCompteDTO(compteService.getCompteById(compteId));
	}

	@GET
	@Path("getCompteByUsername/{username}")
	public List<CompteDTO> findComptesByUsername(@PathParam("username") String username) {
		return convertListCompteToListCompteDTO(compteService.findComptesByUsername(username));
	}

	@GET
	@Path("checkCompte/{username}/{compteId}")
	public boolean checkCompteOwnershipByUsernameAndCompteId(@PathParam("username") String username,
			@PathParam("compteId") Long compteId) {
		return compteService.checkCompteOwnershipByUsernameAndCompteId(username, compteId);
	}

	@GET
	@Path("getCompteByNumeroCompte/{numeroCompte}")
	public CompteDTO getCompteByNumeroCompte(@PathParam("numeroCompte") String numeroCompte) {
		return convertCompteToCompteDTO(compteService.getCompteByNumeroCompte(numeroCompte));
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