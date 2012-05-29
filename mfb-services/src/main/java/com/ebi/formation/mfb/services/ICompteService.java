package com.ebi.formation.mfb.services;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

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
	@Secured("ROLE_CLIENT")
	List<Compte> findComptesByUsername(String username);

	/**
	 * Vérifie si un compte donné appartient à un utilisateur donné
	 * 
	 * @param username
	 *            login de l'utilisateur
	 * @param compteId
	 *            id du {@link Compte}
	 * @return
	 */
	@Secured("ROLE_CLIENT")
	boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId);
}
