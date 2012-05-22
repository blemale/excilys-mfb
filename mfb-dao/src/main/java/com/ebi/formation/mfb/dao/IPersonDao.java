package com.ebi.formation.mfb.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.ebi.formation.mfb.entities.Compte;

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
	 * Recherche la liste des comptes d'un utilisateur en fonction de son username
	 * 
	 * @param username
	 * @return
	 */
	List<Compte> findComptesByUsername(String username);
}
