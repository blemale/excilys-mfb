package com.ebi.formation.mfb.webservicesapi.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

public interface IPersonneWebService {

	@GET
	@Path("getPersonneByUsername/{username}")
	public abstract PersonDTO findPersonByUsername(@PathParam("username") String username);
}