package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import com.ebi.formation.mfb.dao.IAccountDao;
import com.ebi.formation.mfb.entities.Person;
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
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class,
		TransactionalTestExecutionListener.class, RollbackTransactionalDataSetTestExecutionListener.class })
@DataSet("dataSet-AccountDaoTest.xml")
@TransactionConfiguration
@Transactional
public class AccountDaoTest {

	@Autowired
	private IAccountDao accountDao;

	// TODO A VERIFIER AVEC STEPHANE
	/**
	 * Test si un account a bien un ou plusieurs owners
	 */
	@Test
	public void testNoExistingOwners() {
		List<Person> owners = accountDao.findOwnersByAccountId(7L);
		assertEquals(0, owners.size());
	}

	/**
	 * Test si un account a bien le bon proprio en checkant le username de celui ci
	 */
	@Test
	public void testExistingOwnerByUserName() {
		List<Person> owners = accountDao.findOwnersByAccountId(1L);
		assertNotNull(owners);
		assertEquals(1, owners.size());
		assertEquals("bastou", owners.get(0).getUsername());
	}

	/**
	 * Test compte ayant plusieurs owners (compte joint)
	 */
	@Test
	public void testMultipleOwnersByUserName() {
		List<Person> owners = accountDao.findOwnersByAccountId(3L);
		assertEquals(2, owners.size());
		assertEquals("bastou", owners.get(0).getUsername());
		assertEquals("pierre", owners.get(1).getUsername());
	}
}
