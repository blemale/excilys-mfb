package com.ebi.formation.mfb.dao;

import java.util.List;

import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;

/**
 * @author fguillain
 * 
 */
public interface IRoleDao {

	/**
	 * @param right
	 * @return
	 */
	Role findRoleByRight(Right right);

	/**
	 * @return
	 */
	List<Right> findAllRights();
}
