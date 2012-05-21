package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Role;
import com.ebi.formation.mfb.entities.Role.Right;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import com.excilys.ebi.spring.dbunit.test.RollbackTransactionalDataSetTestExecutionListener;

/**
 * Test unitaire de PersonDAO
 * 
 * @author excilys
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:persistence-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		RollbackTransactionalDataSetTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet("dataSet-PersonDaoTest.xml")
@TransactionConfiguration
@Transactional(readOnly = true)
public class PersonDaoTest {

	@Autowired
	private IPersonDao personDao;

	/**
	 * Test si un utilisateur existant est bien recuperé par le DAO
	 */
	@Test
	public void testExistingPerson() {
		UserDetails totoExists = personDao.findUserDetailsByUsername("toto");
		assertNotNull(totoExists);
	}

	/**
	 * Test si le DAO retourne bien null pour un utilisateur inexistant.
	 */
	@Test
	public void testNotExistingPerson() {
		UserDetails titiDoesntExist = personDao.findUserDetailsByUsername("titi");
		assertNull(titiDoesntExist);
	}

	/**
	 * Test la récuperation du rôle d'un utilisateur donné
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetSingleAuthority() {
		UserDetails totoIsAdmin = personDao.findUserDetailsByUsername("toto");
		List<Role> roles = (List<Role>) totoIsAdmin.getAuthorities();
		assertTrue(roles.get(0).getAuthority() == Right.ROLE_ADMIN.name());
	}

	/**
	 * Test la récuperation de plusieurs rôles pour un utilisateur donné
	 */
	@Test
	public void testGetMultipleAuthorities() {
		UserDetails fooIsAdminAndClient = personDao.findUserDetailsByUsername("foo");
		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>) fooIsAdminAndClient.getAuthorities();
		assertTrue(roles.get(0).getAuthority() == Right.ROLE_ADMIN.name());
		assertTrue(roles.get(1).getAuthority() == Right.ROLE_CLIENT.name());
	}

	/**
	 * Test lorsqu'un utilisatuer n'a aucun compte
	 */
	@Test
	public void testNoAccount() {
		List<Compte> accounts = personDao.findComptesByUserId(1L);
		assertTrue(accounts.isEmpty());
	}

	/**
	 * Test lorsqu'un utilisateur a un seul compte
	 */
	@Test
	public void testSingleAccount() {
		List<Compte> accounts = personDao.findComptesByUserId(2L);
		assertEquals(1, accounts.size());
	}

	/**
	 * Test lorsqu'un utilisateur a plusieurs comptes
	 */
	@Test
	public void testMultiplesAccounts() {
		List<Compte> accounts = personDao.findComptesByUserId(3L);
		assertEquals(2, accounts.size());
	}
}
