package com.ebi.formation.mfb.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

@Service
@Produces({ "application/json", "text/xml" })
public class PersonneWebService {

	@Autowired
	private IPersonService personneService;
	@Autowired
	private DTOBinder binder;

	@GET
	@Path("getPersonneByUsername/{username}")
	public PersonDTO findPersonByUsername(@PathParam("username") String username) {
		return binder.bindFromBusinessObject(PersonDTO.class, personneService.findPersonByUsername(username));
	}
}
