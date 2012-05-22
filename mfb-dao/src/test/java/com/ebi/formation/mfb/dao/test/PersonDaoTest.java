package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.entities.Role.Right;
import com.excilys.ebi.spring.dbunit.test.DataSet;
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
		RollbackTransactionalDataSetTestExecutionListener.class })
@TransactionConfiguration
@Transactional(readOnly = true)
public class PersonDaoTest {

	@Autowired
	private IPersonDao personDao;

	/**
	 * Test si un utilisateur existant est bien recuperé par le DAO
	 */
	@DataSet("dataSet-PersonDaoTest.xml")
	@Test
	public void testExistingPerson() {
		UserDetails totoExists = personDao.findUserDetailsByUsername("toto");
		assertNotNull(totoExists);
	}

	/**
	 * Test si le DAO retourne bien null pour un utilisateur inexistant.
	 */
	@DataSet("dataSet-PersonDaoTest.xml")
	@Test
	public void testNotExistingPerson() {
		UserDetails titiDoesntExist = personDao.findUserDetailsByUsername("titi");
		assertNull(titiDoesntExist);
	}

	/**
	 * Test la récuperation du rôle d'un utilisateur donné
	 */
	@DataSet("dataSet-PersonDaoTest.xml")
	@Test
	public void testGetSingleAuthority() {
		UserDetails totoIsAdmin = personDao.findUserDetailsByUsername("toto");
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>(totoIsAdmin.getAuthorities());
		assertTrue(roles.get(0).getAuthority() == Right.ROLE_ADMIN.name());
	}

	/**
	 * Test la récuperation de plusieurs rôles pour un utilisateur donné
	 */
	@DataSet("dataSet-PersonDaoTest.xml")
	@Test
	public void testGetMultipleAuthorities() {
		UserDetails fooIsAdminAndClient = personDao.findUserDetailsByUsername("foo");
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>(fooIsAdminAndClient.getAuthorities());
		assertTrue(roles.get(0).getAuthority() == Right.ROLE_ADMIN.name());
		assertTrue(roles.get(1).getAuthority() == Right.ROLE_CLIENT.name());
	}

	/**
	 * 
	 */
	@DataSet("dataSet-PersonDaoTest.xml")
	@Test
	public void testGetLastAndFirstName() {
		Person p = personDao.findPersonByUsername("toto");
		assertEquals("toto1", p.getFirstName());
		assertEquals("toto2", p.getLastName());
		p = personDao.findPersonByUsername("foo");
		assertEquals("foo1", p.getFirstName());
		assertEquals("foo2", p.getLastName());
		p = personDao.findPersonByUsername("bastou");
		assertEquals("bastou1", p.getFirstName());
		assertEquals("bastou2", p.getLastName());
	}
}
