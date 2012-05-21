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
	 * Retourne la liste des comptes de l'utilisateur dont l'id est passé en paramètre
	 * 
	 * @param id
	 * @return List<Compte>
	 */
	List<Compte> findComptesByUserId(long id);
}
