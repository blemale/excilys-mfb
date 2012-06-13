package com.ebi.formation.mfb.webservicesapi.jaxrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;

/**
 * @author excilys
 * 
 */
public interface ICompteWebService {

	/**
	 * @param compteId
	 * @return
	 */
	@GET
	@Path("getCompteById/{compteId}")
	CompteDTO getCompteById(@PathParam("compteId") Long compteId);

	/**
	 * @param username
	 * @return
	 */
	@GET
	@Path("getCompteByUsername/{username}")
	List<CompteDTO> findComptesByUsername(@PathParam("username") String username);

	/**
	 * @param username
	 * @param compteId
	 * @return
	 */
	@GET
	@Path("checkCompte/{username}/{compteId}")
	boolean checkCompteOwnershipByUsernameAndCompteId(@PathParam("username") String username,
			@PathParam("compteId") Long compteId);

	/**
	 * @param numeroCompte
	 * @return
	 */
	@GET
	@Path("getCompteByNumeroCompte/{numeroCompte}")
	CompteDTO getCompteByNumeroCompte(@PathParam("numeroCompte") String numeroCompte);
}