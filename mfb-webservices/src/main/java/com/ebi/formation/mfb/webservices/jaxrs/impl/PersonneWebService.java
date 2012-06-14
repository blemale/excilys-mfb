package com.ebi.formation.mfb.webservices.jaxrs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jdto.DTOBinder;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebi.formation.mfb.servicesapi.IPersonService;
import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;
import com.ebi.formation.mfb.webservicesapi.jaxrs.IPersonneWebService;

/**
 * Implémentation de {@link IPersonneWebService}.
 * 
 * @author excilys
 * 
 */
public class PersonneWebService implements IPersonneWebService {

	@Autowired
	private IPersonService personneService;
	@Autowired
	private DTOBinder binder;

	/*
	 * (non-Javadoc)
	 * @see com.ebi.formation.mfb.webservices.jaxrs.impl.IPersonneWebService#findPersonByUsername(java.lang.String)
	 */
	@Override
	@GET
	@Path("getPersonneByUsername/{username}")
	public PersonDTO findPersonByUsername(@PathParam("username") String username) {
		return binder.bindFromBusinessObject(PersonDTO.class, personneService.findPersonByUsername(username));
	}
}
