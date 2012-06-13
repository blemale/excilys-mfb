package com.ebi.formation.mfb.webservicesapi.jaxws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.IPersonService.ReturnCodePerson;
import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

/**
 * @author excilys
 * 
 */
@WebService
public interface IPersonWebService {

	/**
	 * @param username
	 * @return
	 */
	PersonDTO findPersonByUsername(@WebParam(name = "username") String username);

	/**
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @param listRights
	 * @return
	 */
	ReturnCodePerson save(@WebParam(name = "username") String username, @WebParam(name = "firstname") String firstname,
			@WebParam(name = "lastname") String lastname, @WebParam(name = "password") String password,
			@WebParam(name = "listRights") List<Right> listRights);

	/**
	 * @return
	 */
	List<PersonDTO> findAllPersons();
}
