package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.impl.RoleDao;
import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.RollbackTransactionalDataSetTestExecutionListener;

/**
 * Test unitaire pour RoleDao
 * 
 * @author fguillain
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:persistence-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		RollbackTransactionalDataSetTestExecutionListener.class })
@TransactionConfiguration
@Transactional(readOnly = true)
public class RoleDaoTest {

	@Autowired
	private RoleDao roleDao;

	/**
	 * Test la récupération d'un Role via un Right
	 */
	@DataSet("dataSet-RoleDaoTest.xml")
	@Test
	public void testFindRoleByRight() {
		Role r = roleDao.findRoleByRight(Right.ROLE_ADMIN);
		assertNotNull(r);
		assertTrue(1L == r.getId());
		r = roleDao.findRoleByRight(Right.ROLE_CLIENT);
		assertNotNull(r);
		assertTrue(2L == r.getId());
	}

	/**
	 * Test la récupération de tous les rôles
	 */
	@DataSet("dataSet-RoleDaoTest.xml")
	@Test
	public void testFindAllRoles() {
		List<Right> listRights = roleDao.findAllRights();
		assertEquals(2, listRights.size());
	}
}
