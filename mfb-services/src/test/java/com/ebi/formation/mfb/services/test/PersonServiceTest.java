package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.IPersonService;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:services-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet("dataSet-CompteServiceTest.xml")
public class PersonServiceTest {

	@Autowired
	private IPersonService personService;

	/**
	 * Test le cas où un user n'a pas de compte
	 */
	@Test
	public void testNotExistingAccount() {
		List<Compte> comptes = personService.findComptesByUsername("toto");
		assertEquals(0, comptes.size());
	}

	/**
	 * Test lorsqu'un utilisateur a un seul compte
	 */
	@Test
	public void testSingleAccount() {
		List<Compte> accounts = personService.findComptesByUsername("foo");
		assertEquals(1, accounts.size());
	}

	/**
	 * Test lorsqu'un utilisateur a plusieurs comptes
	 */
	@Test
	public void testMultiplesAccounts() {
		List<Compte> accounts = personService.findComptesByUsername("bastou");
		assertEquals(2, accounts.size());
		assertEquals(new Long(2), accounts.get(0).getId());
		assertEquals(new Long(3), accounts.get(1).getId());
	}
}
