package com.ebi.formation.mfb.dao;

import java.math.BigDecimal;
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

	/**
	 * Vérifie si un compte appartient bien à une personne donnée
	 * 
	 * @param username
	 * @param compteId
	 * @return
	 */
	boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId);

	/**
	 * Retourne un compte grâce à son id.
	 * 
	 * @param id
	 *            un id donné
	 * @return un compte
	 */
	Compte findCompteById(long id);

	/**
	 * Retourne le solde d'un compte depuis son id.
	 * 
	 * @param id
	 * @return
	 */
	BigDecimal findMontantCompteById(Long id);
}