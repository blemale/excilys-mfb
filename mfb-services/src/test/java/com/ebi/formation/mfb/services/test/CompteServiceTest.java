package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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

/**
 * Test unitaire de CompteService
 * 
 * @author excilys
 * 
 */
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

	/**
	 * Test qu'un compte appartient à un utilisateur.
	 */
	@Test
	public void testOwnership() {
		when(compteDao.checkCompteOwnershipByUsernameAndCompteId("toto", 1L)).thenReturn(false);
		when(compteDao.checkCompteOwnershipByUsernameAndCompteId("foo", 1L)).thenReturn(true);
		when(compteDao.checkCompteOwnershipByUsernameAndCompteId("bastou", 2L)).thenReturn(true);
		when(compteDao.checkCompteOwnershipByUsernameAndCompteId("bastou", 3L)).thenReturn(true);
		assertFalse(compteService.checkCompteOwnershipByUsernameAndCompteId("toto", 1L));
		assertTrue(compteService.checkCompteOwnershipByUsernameAndCompteId("foo", 1L));
		assertTrue(compteService.checkCompteOwnershipByUsernameAndCompteId("bastou", 2L));
		assertTrue(compteService.checkCompteOwnershipByUsernameAndCompteId("bastou", 3L));
	}

	/**
	 * Test la récupération d'un compte par son id.
	 */
	@Test
	public void testGetCompteById() {
		when(compteDao.findCompteById(1)).thenReturn(new Compte());
		when(compteDao.findCompteById(0)).thenReturn(null);
		assertNotNull(compteService.getCompteById(1L));
		assertNull(compteService.getCompteById(0L));
	}

	/**
	 * Test la récupération d'un compte par son numeroCompte.
	 */
	@Test
	public void testGetCompteByNumeroCompte() {
		when(compteDao.findCompteByNumeroCompte("foo")).thenReturn(new Compte());
		when(compteDao.findCompteByNumeroCompte("bar")).thenReturn(null);
		assertNotNull(compteService.getCompteByNumeroCompte("foo"));
		assertNull(compteService.getCompteByNumeroCompte("bar"));
	}

	/**
	 * Test la récupération de tous les comptes
	 */
	@Test
	public void testFindAllComtpes() {
		Compte c1 = new Compte();
		Compte c2 = new Compte();
		Compte c3 = new Compte();
		List<Compte> listComptes = new ArrayList<Compte>();
		listComptes.add(c1);
		listComptes.add(c2);
		listComptes.add(c3);
		when(compteDao.findAllComptes()).thenReturn(listComptes);
		List<Compte> listComptes2 = compteService.findAllComptes();
		assertEquals(3, listComptes2.size());
	}
}
