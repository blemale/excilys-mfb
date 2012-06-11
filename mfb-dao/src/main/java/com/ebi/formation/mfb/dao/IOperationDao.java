package com.ebi.formation.mfb.dao;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import com.ebi.formation.mfb.entities.Operation;

/**
 * Cette interface représente le contrat à implémenter des DAO pour l'entité Operation.
 * 
 * @author excilys
 * 
 */
public interface IOperationDao {

	/**
	 * Recherche la liste des operations d'un compte pour un mois donné
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @return
	 */
	BigDecimal findTotalOperationsCarteByMonth(long idCompte, DateTime date, DateTime datePlusUnMois);

	/**
	 * Retourne le nombre d'operations carte d'un compte pour un mois donné
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @return
	 */
	long findNumberOfOperationsCarteByMonth(long idCompte, DateTime date, DateTime datePlusUnMois);

	/**
	 * Retourne le nombre d'operations excepté les opérations carte d'un compte pour un mois donné
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @return
	 */
	long findNumberOfOperationsWithoutCarteByMonth(long idCompte, DateTime date, DateTime datePlusUnMois);

	/**
	 * Retourne le nombre d'operations excepté les opérations carte d'un compte pour un mois donné
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @return
	 */
	long findNumberOfVirementsByMonth(long idCompte, DateTime date, DateTime datePlusUnMois);

	/**
	 * Recherche la liste des operations d'un compte (sauf les opérations par carte) pour un mois donné et paginé
	 * suivant un offset
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @param offset
	 * @param numberOfResults
	 * @return
	 */
	List<Operation> findOperationsWithoutCarteByMonthPaginated(long idCompte, DateTime date, DateTime datePlusUnMois,
			int offset, int numberOfResults);

	/**
	 * Recherche la liste des operations carte d'un compte pour un mois donné et paginé suivant un offset
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @param offset
	 * @param numberOfResults
	 * @return
	 */
	List<Operation> findOperationsCarteByMonthPaginated(long idCompte, DateTime date, DateTime datePlusUnMois,
			int offset, int numberOfResults);

	/**
	 * Recherche la liste des virements d'une personne pour un mois donné et paginé suivant un offset
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @param offset
	 * @param numberOfResults
	 * @return
	 */
	List<Operation> findVirementsByMonthPaginated(long idCompte, DateTime date, DateTime datePlusUnMois, int offset,
			int numberOfResults);

	/**
	 * Récupère la liste des opérations pour un mois donné.
	 * 
	 * @param idCompte
	 * @param date
	 * @param datePlusUnMois
	 * @return
	 */
	List<Operation> findAllOperationsByMonthByCompte(long idCompte, DateTime date, DateTime datePlusUnMois);

	/**
	 * Méthode permettant de persister en base une nouvelle opération.
	 * 
	 * @param operation
	 *            l'opération à persister
	 */
	void save(Operation operation);

	/**
	 * Met à jour les comptes à partir des opérations.
	 * 
	 */
	void updateCompteWithNewOperations();
}
