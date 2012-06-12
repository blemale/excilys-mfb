package com.ebi.formation.mfb.webservicesapi.jaxrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;

public interface ICompteWebService {

	@GET
	@Path("getCompteById/{compteId}")
	CompteDTO getCompteById(@PathParam("compteId") Long compteId);

	@GET
	@Path("getCompteByUsername/{username}")
	List<CompteDTO> findComptesByUsername(@PathParam("username") String username);

	@GET
	@Path("checkCompte/{username}/{compteId}")
	boolean checkCompteOwnershipByUsernameAndCompteId(@PathParam("username") String username,
			@PathParam("compteId") Long compteId);

	@GET
	@Path("getCompteByNumeroCompte/{numeroCompte}")
	CompteDTO getCompteByNumeroCompte(@PathParam("numeroCompte") String numeroCompte);
}