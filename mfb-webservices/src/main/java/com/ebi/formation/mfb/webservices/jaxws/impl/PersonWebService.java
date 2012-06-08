package com.ebi.formation.mfb.webservices.jaxws.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.services.IPersonService;

@WebService(endpointInterface = "com.ebi.formation.mfb.webservices.jaxws.IPersonWebService")
public class PersonWebService implements IPersonService {

	@Autowired
	private IPersonService personService;

	@Override
	public Person findPersonByUsername(String username) {
		return personService.findPersonByUsername(username);
	}

	@Override
	public ReturnCodePerson save(String username, String firstname, String lastname, String password) {
		return personService.save(username, firstname, lastname, password);
	}
}
