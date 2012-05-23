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

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.services.impl.CompteService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:/services-config.xml")
public class CompteServiceTest {

	@Mock
	ICompteDao compteDao;
	@InjectMocks
	CompteService compteService;

	/**
	 * Test le cas où un user n'a pas de compte
	 */
	@Test
	public void testNotExistingAccount() {
		when(compteDao.findComptesByUsername("foo")).thenReturn(new ArrayList<Compte>());
		List<Compte> result = compteService.findComptesByUsername("foo");
		assertEquals(0, result.size());
	}

	/**
	 * Test lorsqu'un utilisateur a un seul compte
	 */
	@Test
	public void testSingleAccount() {
		List<Compte> comptes = new ArrayList<Compte>();
		comptes.add(new Compte());
		when(compteDao.findComptesByUsername("foo")).thenReturn(comptes);
		List<Compte> result = compteService.findComptesByUsername("foo");
		assertEquals(1, result.size());
	}

	/**
	 * Test lorsqu'un utilisateur a plusieurs comptes
	 */
	@Test
	public void testMultiplesAccounts() {
		List<Compte> comptes = new ArrayList<Compte>();
		comptes.add(new Compte());
		comptes.add(new Compte());
		when(compteDao.findComptesByUsername("foo")).thenReturn(comptes);
		List<Compte> result = compteService.findComptesByUsername("foo");
		assertEquals(2, result.size());
	}
}
