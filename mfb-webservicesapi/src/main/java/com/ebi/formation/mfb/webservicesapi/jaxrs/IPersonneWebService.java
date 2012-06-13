package com.ebi.formation.mfb.webservicesapi.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

/**
 * @author excilys
 * 
 */
public interface IPersonneWebService {

	/**
	 * @param username
	 * @return
	 */
	@GET
	@Path("getPersonneByUsername/{username}")
	PersonDTO findPersonByUsername(@PathParam("username") String username);
}