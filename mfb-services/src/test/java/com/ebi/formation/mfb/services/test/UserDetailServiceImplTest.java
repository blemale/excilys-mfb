package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:services-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet("dataSet-UserDetailsServiceTest.xml")
public class UserDetailServiceImplTest {

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Vérifie si un utilisateur existant est bien recuperé
	 */
	@Test
	public void testExistingUser() {
		UserDetails user = userDetailsService.loadUserByUsername("toto");
		assertNotNull(user);
	}

	/**
	 * Vérifie si un utilisateur inexistant lève bien l'exception demandée par l'interface
	 */
	@Test(expected = UsernameNotFoundException.class)
	public void testNotExistingUser() {
		userDetailsService.loadUserByUsername("titi");
	}
}
