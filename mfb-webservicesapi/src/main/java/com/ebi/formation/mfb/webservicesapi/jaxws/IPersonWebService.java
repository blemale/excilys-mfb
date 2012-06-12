package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.IPersonService.ReturnCodePerson;
import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

@WebService
public interface IPersonWebService {

	PersonDTO findPersonByUsername(@WebParam(name = "username") String username);

	ReturnCodePerson save(@WebParam(name = "username") String username,
			@WebParam(name = "firstname") String firstname, @WebParam(name = "lastname") String lastname,
			@WebParam(name = "password") String password, @WebParam(name = "listRights") List<Right> listRights);

	List<PersonDTO> findAllPersons();
}
