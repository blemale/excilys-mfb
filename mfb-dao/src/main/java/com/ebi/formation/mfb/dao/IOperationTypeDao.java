package com.ebi.formation.mfb.dao;

import java.util.List;

import com.ebi.formation.mfb.entities.OperationType;
import com.ebi.formation.mfb.entities.OperationType.Type;

/**
 * @author excilys
 * 
 */
public interface IOperationTypeDao {

	/**
	 * Méthode permettant de récupérer l'{@link OperationType} de la base correspondant au type passé en paramètre.
	 * 
	 * @param type
	 *            le type dont on veut récupérer l'OperationType depuis la base
	 * @return
	 */
	OperationType getOperationTypeByType(Type type);

	/**
	 * Méthode retournant toutes les types d'opérations
	 * 
	 * @return
	 */
	List<Type> findAllOperationTypes();
}
