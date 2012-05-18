package com.ebi.formation.mfb.dao;

import java.util.List;

import com.ebi.formation.mfb.entities.Person;

/**
 * Cette interface représente le contrat à implémenter des DAO pour l'entité Account.
 * 
 * @author excilys
 * 
 */
public interface IAccountDao {

	/**
	 * Recherche les propriétaires du compte en fonction de son id
	 * 
	 * @param id
	 *            l'id du compte
	 * @return la liste des propriétaires du compte, une liste vide sinon
	 */
	List<Person> findOwnersByAccountId(Long id);
}
