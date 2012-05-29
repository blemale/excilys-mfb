package com.ebi.formation.mfb.dao;

import java.math.BigDecimal;
import java.util.List;

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
	 * @param username
	 * @return
	 */
	public BigDecimal findTotalOperationsCarteByMonth(long idCompte, int month, int year);

	/**
	 * Retourne le nombre d'operations carte d'un compte pour un mois donné
	 * 
	 * @param username
	 * @return
	 */
	public long findNumberOfOperationsCarteByMonth(long idCompte, int month, int year);

	/**
	 * Retourne le nombre d'operations excepté les opérations carte d'un compte pour un mois donné
	 * 
	 * @param username
	 * @return
	 */
	public long findNumberOfOperationsWithoutCarteByMonth(long idCompte, int month, int year);

	/**
	 * Recherche la liste des operations d'un compte (sauf les opérations par carte) pour un mois donné et paginé
	 * suivant un offset
	 * 
	 * @param username
	 * @return
	 */
	public List<Operation> findOperationsWithoutCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults);

	/**
	 * Recherche la liste des operations carte d'un compte pour un mois donné et paginé suivant un offset
	 * 
	 * @param username
	 * @return
	 */
	public List<Operation> findOperationsCarteByMonthPaginated(long idCompte, int month, int year, int offset,
			int numberOfResults);
}
