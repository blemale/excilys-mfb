package com.ebi.formation.mfb.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.webservices.dto.PersonDTO;

@Service
@Produces({ "application/json", "text/xml" })
public class PersonneWebService {

	@Autowired
	private IPersonService personneService;

	@GET
	@Path("getPersonneByUsername/{username}")
	public PersonDTO findPersonByUsername(@PathParam("username") String username) {
		return convertPersonToPersonDTO(personneService.findPersonByUsername(username));
	}

	private PersonDTO convertPersonToPersonDTO(Person person) {
		return new PersonDTO(person.getId(), person.getUsername(), person.getPassword(), person.getFirstName(),
				person.getLastName());
	}
}
