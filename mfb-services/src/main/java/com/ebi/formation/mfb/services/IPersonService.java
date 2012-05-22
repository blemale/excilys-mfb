package com.ebi.formation.mfb.services;

import java.util.List;

import com.ebi.formation.mfb.entities.Compte;

/**
 * Interface du service associé à CompteDao
 * 
 * @author excilys
 * 
 */
public interface IPersonService {

	/**
	 * Retourne la liste des comptes d'un utilisateur via son username
	 * 
	 * @param username
	 * @return
	 */
	List<Compte> findComptesByUsername(String username);
}
