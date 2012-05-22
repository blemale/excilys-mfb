package com.ebi.formation.mfb.services;

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
	Person findPersonByUsername(String username);
}
