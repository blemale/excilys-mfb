package com.ebi.formation.mfb.dao;

import java.util.List;

import com.ebi.formation.mfb.entities.Compte;

/**
 * Cette interface représente le contrat à implémenter des DAO pour l'entité Account.
 * 
 * @author excilys
 * 
 */
public interface ICompteDao {

	/**
	 * Recherche la liste des comptes d'un utilisateur en fonction de son username
	 * 
	 * @param username
	 * @return
	 */
	List<Compte> findComptesByUsername(String username);
}
