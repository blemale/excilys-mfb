package com.ebi.formation.mfb.webservices.jaxws.impl;

import java.util.List;

import javax.jws.WebService;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.IPersonService;
import com.ebi.formation.mfb.services.IPersonService.ReturnCodePerson;
import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;
import com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService;

/**
 * @author excilys
 * 
 */
@WebService(endpointInterface = "com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService")
public class PersonWebService implements IPersonWebService {

	@Autowired
	private IPersonService personService;
	@Autowired
	private DTOBinder binder;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService#findPersonByUsername(java.lang.String)
	 */
	@Override
	public PersonDTO findPersonByUsername(String username) {
		return binder.bindFromBusinessObject(PersonDTO.class, personService.findPersonByUsername(username));
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService#save(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public ReturnCodePerson save(String username, String firstname, String lastname, String password,
			List<Right> listRights) {
		return personService.save(username, firstname, lastname, password, listRights);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservicesapi.jaxws.IPersonWebService#findAllPersons()
	 */
	@Override
	public List<PersonDTO> findAllPersons() {
		return binder.bindFromBusinessObjectList(PersonDTO.class, personService.findAllPersons());
	}
}
