package com.ebi.formation.mfb.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.formation.mfb.services.ICompteService;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;

@Service("compteWebService")
@Produces({ "application/json", "text/xml" })
public class CompteWebService {

	@Autowired
	private ICompteService compteService;
	@Autowired
	private DTOBinder binder;

	@GET
	@Path("getCompteById/{compteId}")
	public CompteDTO getCompteById(@PathParam("compteId") Long compteId) {
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteById(compteId));
	}

	@GET
	@Path("getCompteByUsername/{username}")
	public List<CompteDTO> findComptesByUsername(@PathParam("username") String username) {
		return binder.bindFromBusinessObjectList(CompteDTO.class, compteService.findComptesByUsername(username));
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
		return binder.bindFromBusinessObject(CompteDTO.class, compteService.getCompteByNumeroCompte(numeroCompte));
	}
}