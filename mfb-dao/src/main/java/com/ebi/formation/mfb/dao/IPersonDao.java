package com.ebi.formation.mfb.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.ebi.formation.mfb.entities.Person;

/**
 * Cette interface représente le contrat à implémenter des DAO pour l'entité Person.
 * 
 * @author excilys
 * 
 */
public interface IPersonDao {

	/**
	 * Recherche les données de l'utilisateur en fonction de son username
	 * 
	 * @param username
	 *            le username à rechercher
	 * @return l'utilisateur si il existe, null sinon
	 */
	UserDetails findUserDetailsByUsername(String username);

	/**
	 * Recherche une personne en fonction de son username
	 * 
	 * @param username
	 *            le username à rechercher
	 * @return une personne
	 */
	Person findPersonByUsername(String username);

	/**
	 * Méthode permettant de persister en base une nouvelle personne (partie admin).
	 * 
	 * @param person
	 */
	void save(Person person);
}
