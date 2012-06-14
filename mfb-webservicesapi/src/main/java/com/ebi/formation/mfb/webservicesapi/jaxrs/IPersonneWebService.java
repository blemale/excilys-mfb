package com.ebi.formation.mfb.webservicesapi.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

/**
 * @author excilys
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
public interface IPersonneWebService {

	/**
	 * @param username
	 * @return
	 */
	@GET
	@Path("getPersonneByUsername/{username}")
	PersonDTO findPersonByUsername(@PathParam("username") String username);
}