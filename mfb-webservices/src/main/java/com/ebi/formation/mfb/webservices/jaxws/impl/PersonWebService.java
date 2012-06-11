package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.webservices.jaxws.IPersonWebService;

@WebService(endpointInterface = "com.ebi.formation.mfb.webservices.jaxws.IPersonWebService")
public class PersonWebService implements IPersonWebService {

	@Autowired
	private IPersonService personService;

	@Override
	public Person findPersonByUsername(String username) {
		return personService.findPersonByUsername(username);
	}

	@Override
	public ReturnCodePerson save(String username, String firstname, String lastname, String password,
			List<Right> listRights) {
		return personService.save(username, firstname, lastname, password, listRights);
	}

	@Override
	public List<Person> findAllPersons() {
		return personService.findAllPersons();
	}
}
