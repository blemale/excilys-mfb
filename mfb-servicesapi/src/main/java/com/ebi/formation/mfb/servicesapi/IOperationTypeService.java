package com.ebi.formation.mfb.servicesapi;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.OperationType.Type;
import com.ebi.formation.mfb.entities.Role;

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
	@Secured(Role.ROLE_ADMIN)
	List<Type> findAllOperationTypes();
}
