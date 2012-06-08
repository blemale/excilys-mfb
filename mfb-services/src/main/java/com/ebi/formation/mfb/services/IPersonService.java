package com.ebi.formation.mfb.services;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.Person;

/**
 * Interface du service associé à PersonDao
 * 
 * @author excilys
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
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	ReturnCodePerson save(String username, String firstname, String lastname, String password);
}
