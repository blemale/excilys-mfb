package com.ebi.formation.mfb.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.impl.OperationService.ReturnCodeVirement;

/**
 * Interface du service associé à {@link Operation}
 * 
 * @author excilys
 * 
 */
public interface IOperationService {

	/**
	 * Renvoie le total des opérations carte pour un mois donné. Renvoie null s'il n'y a pas d'opération carte durant ce
	 * mois.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @return le total des opérations carte
	 */
	@Secured("ROLE_CLIENT")
	public BigDecimal getTotalOperationsCarteByMonth(long idCompte, int month, int year);

	/**
	 * Renvoie le nombre d'opérations carte effectuées pour un mois donnée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @return le nombre d'opération carte
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfOperationsCarteByMonth(long idCompte, int month, int year);

	/**
	 * Renvoie le nombre d'opérations non carte effectuées pour un mois donnée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @return le nombre d'opération carte
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfOperationsWithoutCarteByMonth(long idCompte, int month, int year);

	/**
	 * Renvoie le nombre de virement effectuées pour un mois donnée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @return le nombre d'opération carte
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfVirementByMonth(long idCompte, int month, int year);

	/**
	 * Renvoie la liste des opérations non carte ordonnées par date descendante pour un mois donné de façon paginée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param offset
	 *            l'offset de départ en nombre de ligne(0, ...)
	 * @param numberOfResults
	 *            le nombre d'opérations retournées
	 * @return la liste des {@link Operation}
	 */
	@Secured("ROLE_CLIENT")
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults);

	/**
	 * Renvoie la liste des opérations non carte ordonnées par date descendante pour un mois donné de façon paginée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param page
	 *            la page à afficher avec le nombre de résultats par défaut. Commence à 0.
	 * @return la liste des {@link Operation}
	 */
	@Secured("ROLE_CLIENT")
	public List<Operation> getOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int page);

	/**
	 * Renvoie la liste des opérations carte ordonnées par date descendante pour un mois donné de façon paginée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param offset
	 *            l'offset de départ en nombre de ligne(0, ...)
	 * @param numberOfResults
	 *            le nombre d'opérations retournées
	 * @return la liste des {@link Operation}
	 */
	@Secured("ROLE_CLIENT")
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults);

	/**
	 * Renvoie la liste des opérations carte ordonnées par date descendante pour un mois donné de façon paginée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param page
	 *            la page à afficher avec le nombre de résultats par défaut. Commence à 0.
	 * @return la liste des {@link Operation}
	 */
	@Secured("ROLE_CLIENT")
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page);

	/**
	 * Renvoie la liste des virements ordonnées par date descendante pour un mois donné de façon paginée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param offset
	 *            l'offset de départ en nombre de ligne(0, ...)
	 * @param numberOfResults
	 *            le nombre d'opérations retournées
	 * @return la liste des {@link Operation}
	 */
	@Secured("ROLE_CLIENT")
	public List<Operation> getVirementsByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults);

	/**
	 * Renvoie la liste des virements ordonnées par date descendante pour un mois donné de façon paginée.
	 * 
	 * @param idCompte
	 *            id du {@link Compte}.
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param page
	 *            la page à afficher avec le nombre de résultats par défaut. Commence à 0.
	 * @return la liste des {@link Operation}
	 */
	@Secured("ROLE_CLIENT")
	public List<Operation> getVirementsByMonthPaginated(long idCompte, int month, int year, int page);

	/**
	 * Renvoie le nombres de pages nécessaires pour afficher toutes les opérations non carte d'un mois donné
	 * 
	 * @param idCompte
	 *            id du {@link Compte}
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @return le nombre de pages à afficher
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year);

	/**
	 * Renvoie le nombres de pages nécessaires pour afficher toutes les opérations non carte d'un mois donné
	 * 
	 * @param idCompte
	 *            id du {@link Compte}
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param numberOfResults
	 *            le nombre de résultats par page
	 * @return le nombre de pages à afficher
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfPagesForOperationsWithoutCartesByMonth(long idCompte, int month, int year,
			int numberOfResults);

	/**
	 * Renvoie le nombres de pages nécessaires pour afficher toutes les opérations carte d'un mois donné
	 * 
	 * @param idCompte
	 *            id du {@link Compte}
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @return le nombre de pages à afficher
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int year);

	/**
	 * Renvoie le nombres de pages nécessaires pour afficher toutes les opérations non carte d'un mois donné
	 * 
	 * @param idCompte
	 *            id du {@link Compte}
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param numberOfResults
	 *            le nombre de résultats par page
	 * @return le nombre de pages à afficher
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfPagesForOperationsCartesByMonth(long idCompte, int month, int years, int numberOfResults);

	/**
	 * Renvoie le nombres de pages nécessaires pour afficher tous les virements d'un mois donné
	 * 
	 * @param idCompte
	 *            id du {@link Compte}
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @return le nombre de pages à afficher
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int year);

	/**
	 * Renvoie le nombres de pages nécessaires pour afficher toutes les opérations non carte d'un mois donné
	 * 
	 * @param idCompte
	 *            id du {@link Compte}
	 * @param month
	 *            un mois donné (1 = janvier, ...)
	 * @param year
	 *            une année donnée (yyyy)
	 * @param numberOfResults
	 *            le nombre de résultats par page
	 * @return le nombre de pages à afficher
	 */
	@Secured("ROLE_CLIENT")
	public long getNumberOfPagesForVirementByMonth(long idCompte, int month, int years, int numberOfResults);

	/**
	 * <<<<<<< HEAD
	 * 
	 * Renvoie toutes les opérations d'un compte pour un mois donné.
	 * 
	 * @param idCompte
	 * @param month
	 * @param year
	 * @return
	 */
	List<Operation> getAllOperationsByMonthByCompte(long idCompte, int month, int year);

	/**
	 * Permet d'effectuer un virement entre deux comptes, et d'ajouter un motif de virement facultatif.
	 * 
	 * @param idCompteADebiter
	 * @param idCompteACrediter
	 * @param label
	 * @param montant
	 * @return 0 si tout s'est bien passé; 1 si les deux comptes sont identiques; 2 si le virement entraîne un
	 *         découvert; 3 si le compte à débiter n'existe pas; 4 si le compte à créditer n'existe pas; 5 si le montant
	 *         est négatif ou nul
	 */
	@Secured("ROLE_CLIENT")
	public ReturnCodeVirement doVirement(long idCompteADebiter, long idCompteACrediter, String label, BigDecimal montant);
}
