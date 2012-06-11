package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.services.IPersonService.ReturnCodePerson;
import com.ebi.formation.mfb.webservices.dto.PersonDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService;

@WebService(endpointInterface = "com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService")
public class PersonWebService implements IPersonWebService {

	@Autowired
	private IPersonService personService;

	@Override
	public PersonDTO findPersonByUsername(String username) {
		return convertPersonToPersonDTO(personService.findPersonByUsername(username));
	}

	@Override
	public ReturnCodePerson save(String username, String firstname, String lastname, String password,
			List<Right> listRights) {
		return personService.save(username, firstname, lastname, password, listRights);
	}

	@Override
	public List<PersonDTO> findAllPersons() {
		return convertListCompteToListPersonDTO(personService.findAllPersons());
	}

	private PersonDTO convertPersonToPersonDTO(Person person) {
		return new PersonDTO(person.getId(), person.getUsername(), person.getPassword(), person.getFirstName(),
				person.getLastName());
	}

	private List<PersonDTO> convertListCompteToListPersonDTO(List<Person> persons) {
		List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
		for (Person p : persons) {
			personDTOs.add(convertPersonToPersonDTO(p));
		}
		return personDTOs;
	}
}
