package com.ebi.formation.mfb.services;

import java.util.List;

import com.ebi.formation.mfb.entities.Compte;

/**
 * Interface du service associé à CompteDao
 * 
 * @author excilys
 * 
 */
public interface ICompteService {

	/**
	 * Retourne la liste des comptes d'un utilisateur via son username
	 * 
	 * @param username
	 * @return
	 */
	List<Compte> findComptesByUsername(String username);

	/**
	 * Vérifie qu'un compte appartient à un utilisateur désigné par son username.
	 * 
	 * @param username
	 * @param compteId
	 * @return vrai si le compte appartient bien à l'utilisateur, faux sinon.
	 */
	boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId);

	/**
	 * Récupère un compte par son id.
	 * 
	 * @param compteId
	 *            l'id du {@link Compte}
	 * @return un {@link Compte}.
	 */
	Compte getCompteById(Long compteId);
}
