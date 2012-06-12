package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.ebi.formation.mfb.dao.IRoleDao;
import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;
import com.ebi.formation.mfb.services.impl.RoleService;

/**
 * Test unitaire de RoleService
 * 
 * @author fguillain
 * 
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:/services-config.xml")
public class RoleServiceTest {

	@Mock
	IRoleDao roleDao;
	@InjectMocks
	RoleService roleService;

	/**
	 * Test
	 */
	@Test
	public void testFindRoleByRight() {
		Role r1 = new Role();
		r1.setRight(Right.ROLE_CLIENT);
		Role r2 = new Role();
		r2.setRight(Right.ROLE_ADMIN);
		when(roleDao.findRoleByRight(Right.ROLE_CLIENT)).thenReturn(r1);
		when(roleDao.findRoleByRight(Right.ROLE_ADMIN)).thenReturn(r2);
		Role r3 = roleService.findRoleByRight(Right.ROLE_CLIENT);
		assertEquals(Right.ROLE_CLIENT, r3.getRight());
		Role r4 = roleService.findRoleByRight(Right.ROLE_ADMIN);
		assertEquals(Right.ROLE_ADMIN, r4.getRight());
	}

	/**
	 * Test
	 */
	@Test
	public void testFindAllRights() {
		List<Right> listRights = new ArrayList<Right>();
		listRights.add(Right.ROLE_CLIENT);
		listRights.add(Right.ROLE_ADMIN);
		when(roleDao.findAllRights()).thenReturn(listRights);
		List<Right> listRights2 = roleService.findAllRights();
		assertEquals(2, listRights2.size());
	}
}
