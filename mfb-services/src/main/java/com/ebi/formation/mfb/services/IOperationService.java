package com.ebi.formation.mfb.services;

import java.math.BigDecimal;
import java.util.List;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Operation;

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
	public BigDecimal getTotalOperationsCarteByMonth(long idCompte, int month, int year);

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
	public long getNumbreOfOperationsCarteByMonth(long idCompte, int month, int year);

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
	public long getNumbreOfOperationsWhithoutCarteByMonth(long idCompte, int month, int year);

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
	public List<Operation> getOperationsCarteByMonthPaginated(long idCompte, int month, int year, int page);
}
