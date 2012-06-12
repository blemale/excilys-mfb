package com.ebi.formation.mfb.services;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;

/**
 * Interface du service associé à RoleDao
 * 
 * @author fguillain
 * 
 */
public interface IRoleService {

	/**
	 * Permet de retourner une Role par rapport à un Right
	 * 
	 * @param right
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	Role findRoleByRight(Right right);

	/**
	 * Permet de retourner la liste des tous les Rights
	 * 
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	List<Right> findAllRights();
}
