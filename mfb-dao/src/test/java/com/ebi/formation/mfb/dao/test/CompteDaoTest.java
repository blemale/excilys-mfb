package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.entities.Compte;
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
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		RollbackTransactionalDataSetTestExecutionListener.class, TransactionalTestExecutionListener.class, })
@TransactionConfiguration
@Transactional
public class CompteDaoTest {

	@Autowired
	private ICompteDao compteDao;

	/**
	 * Test lorsqu'un utilisateur n'a aucun compte
	 */
	@DataSet("dataSet-CompteDaoTest.xml")
	@Test
	public void testNoAccount() {
		List<Compte> accounts = compteDao.findComptesByUsername("toto");
		assertTrue(accounts.isEmpty());
	}

	/**
	 * Test lorsqu'un utilisateur a un seul compte
	 */
	@DataSet("dataSet-CompteDaoTest.xml")
	@Test
	public void testSingleAccount() {
		List<Compte> accounts = compteDao.findComptesByUsername("foo");
		assertEquals(1, accounts.size());
	}

	/**
	 * Test lorsqu'un utilisateur a plusieurs comptes
	 */
	@DataSet("dataSet-CompteDaoTest.xml")
	@Test
	public void testMultiplesAccounts() {
		List<Compte> accounts = compteDao.findComptesByUsername("bastou");
		assertEquals(2, accounts.size());
	}

	@DataSet("dataSet-CompteDaoTest.xml")
	@Test
	public void testCompteOwnership() {
		assertFalse(compteDao.checkCompteOwnershipByUsernameAndCompteId("toto", 1L));
		assertTrue(compteDao.checkCompteOwnershipByUsernameAndCompteId("foo", 1L));
		assertTrue(compteDao.checkCompteOwnershipByUsernameAndCompteId("bastou", 2L));
		assertTrue(compteDao.checkCompteOwnershipByUsernameAndCompteId("bastou", 3L));
	}

	@DataSet("dataSet-CompteDaoTest.xml")
	@Test
	public void testFindCompteById() {
		Compte result1 = compteDao.findCompteById(1);
		Compte result2 = compteDao.findCompteById(0);
		assertNotNull(result1);
		assertEquals(new Long(1L), result1.getId());
		assertNull(result2);
	}
}
