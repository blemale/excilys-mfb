package com.ebi.formation.mfb.services;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;

/**
 * @author fguillain
 * 
 */
public interface IRoleService {

	/**
	 * @param right
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	Role findRoleByRight(Right right);

	/**
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	List<Right> findAllRights();
}
