package com.ebi.formation.mfb.servicesapi;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Role;

/**
 * Interface du service associé à CompteDao
 * 
 * @author excilys
 * @author fguillain
 * 
 */
public interface ICompteService {

	public enum ReturnCodeCompte {
		OK, OWNER_INEXISTANT
	}

	/**
	 * Retourne la liste des comptes d'un utilisateur via son username
	 * 
	 * @param username
	 * @return
	 */
	@Secured(Role.ROLE_CLIENT)
	List<Compte> findComptesByUsername(String username);

	/**
	 * Vérifie si un compte donné appartient à un utilisateur donné
	 * 
	 * @param username
	 *            login de l'utilisateur
	 * @param compteId
	 *            id du {@link Compte}
	 * @return vrai si le compte appartient bien à l'utilisateur, faux sinon.
	 */
	@Secured(Role.ROLE_CLIENT)
	boolean checkCompteOwnershipByUsernameAndCompteId(String username, Long compteId);

	/**
	 * Récupère un compte par son id.
	 * 
	 * @param compteId
	 *            l'id du {@link Compte}
	 * @return un {@link Compte} ou null s le compte n'existe pas.
	 */
	@Secured(Role.ROLE_CLIENT)
	Compte getCompteById(Long compteId);

	/**
	 * Récupère un compte par son numeroCompte.
	 * 
	 * @param numeroCompte
	 *            le numeroCompte du {@link Compte}
	 * @return un {@link Compte} ou null s le compte n'existe pas.
	 */
	@Secured(Role.ROLE_CLIENT)
	Compte getCompteByNumeroCompte(String numeroCompte);

	/**
	 * Sauvegarde un compte et renvoie le numéro de compte généré
	 * 
	 * @param libelle
	 * @param usernamePerson
	 * @param solde
	 * @return
	 */
	@Secured(Role.ROLE_ADMIN)
	Object[] save(String libelle, String usernamePerson, BigDecimal solde);

	/**
	 * Méthode retournant tous les comptes
	 * 
	 * @return
	 */
	@Secured(Role.ROLE_ADMIN)
	List<Compte> findAllComptes();
}
