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

	/**
	 * Retourne une personne via son username
	 * 
	 * @param username
	 * @return
	 */
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	Person findPersonByUsername(String username);
}
