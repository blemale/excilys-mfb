package com.ebi.formation.mfb.webservicesapi.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.security.core.userdetails.User;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

/**
 * Interface du webservice REST d'accès aux services métier des {@link Person}.
 * 
 * @author excilys
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
public interface IPersonneWebService {

	/**
	 * Permet de récupérer un {@link User} grâce à son username.
	 * 
	 * @param username
	 * @return
	 */
	@GET
	@Path("getPersonneByUsername/{username}")
	PersonDTO findPersonByUsername(@PathParam("username") String username);
}