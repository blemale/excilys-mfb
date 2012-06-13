package com.ebi.formation.mfb.services;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;

/**
 * Interface du service associé à PersonDao
 * 
 * @author excilys
 * @author fguillain
 * 
 */
public interface IPersonService {

	public enum ReturnCodePerson {
		OK, IDENTICAL_USERNAME
	}

	/**
	 * Retourne une personne via son username
	 * 
	 * @param username
	 * @return
	 */
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	Person findPersonByUsername(String username);

	/**
	 * Sauvegarde une personne
	 * 
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @param listRights
	 * @return
	 */
	@Secured(Role.ROLE_ADMIN)
	ReturnCodePerson save(String username, String firstname, String lastname, String password, List<Right> listRights);

	/**
	 * Retourne la liste de toutes les personnes
	 * 
	 * @return
	 */
	@Secured(Role.ROLE_ADMIN)
	List<Person> findAllPersons();
}
