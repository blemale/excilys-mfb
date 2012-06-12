package com.ebi.formation.mfb.services;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.OperationType.Type;

/**
 * Interface du service associé à OperationTypeDao
 * 
 * @author fguillain
 * 
 */
public interface IOperationTypeService {

	/**
	 * Méthode retournant tous les types d'opération
	 * 
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	List<Type> findAllOperationTypes();
}
