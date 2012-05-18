package com.ebi.formation.mfb.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.ebi.formation.mfb.entities.Account;

/**
 * Cette interface représente le contrat à implémenter des DAO pour l'entité Person.
 * 
 * @author excilys
 * 
 */
public interface IPersonDao {

	/**
	 * Recherche les données de l'utilisateur en fonction de son nom d'utilisateur
	 * 
	 * @param username
	 *            le nom d'utilisateur à rechercher
	 * @return l'utilisateur si il existe, null sinon
	 */
	UserDetails findUserDetailsByUsername(String username);

	/**
	 * Recherche les comptes de l'utilisateur en fonction de son id
	 * 
	 * @param id
	 *            l'id de l'utilisateur
	 * @return la liste des comptes de l'utilisateur, null sinon
	 */
	List<Account> findAccountsByUserId(Long id);
}
