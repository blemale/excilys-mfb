package com.ebi.formation.mfb.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ebi.formation.mfb.entities.Compte;

/**
 * Cette interface représente le contrat à implémenter des DAO pour l'entité Compte.
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
	 * Retourne un compte grâce à son numero de compte.
	 * 
	 * @param numeroCompte
	 *            un numero de compte donné
	 * @return un compte ou null si le compte n'est pas trouvé
	 */
	Compte findCompteByNumeroCompte(String numeroCompte);

	/**
	 * Retourne le solde d'un compte depuis son id.
	 * 
	 * @param id
	 * @return
	 */
	BigDecimal findMontantCompteById(Long id);

	/**
	 * Retourne l'encours carte d'un compte depuis son id.
	 * 
	 * @param id
	 * @return
	 */
	BigDecimal findEncoursCarteCompteById(Long id);

	/**
	 * Méthode permettant de persister en base un nouveau compte (partie admin).
	 * 
	 * @param compte
	 */
	void save(Compte compte);

	/**
	 * Méthode retournant tous les comptes
	 * 
	 * @return
	 */
	List<Compte> findAllComptes();

	/**
	 * @param id
	 * @param montant
	 */
	void updateCompteSolde(Long id, BigDecimal montant);

	/**
	 * @param id
	 * @param montant
	 */
	void updateCompteSoldeAndEncoursCarte(Long id, BigDecimal montant);

	/**
	 * @param id
	 * @param montant
	 */
	void updateCompteSoldePrevisionnel(Long id, BigDecimal montant);

	/**
	 * @param id
	 * @param montant
	 */
	void updateCompteEncoursCarteAndSoldePrevisionnel(Long id, BigDecimal montant);

	/**
	 * @param id
	 * @param montant
	 */
	void updateCompteSoldeAndSoldePrevisionnel(Long id, BigDecimal montant);
}