package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.services.impl.UserDetailsServiceImpl;

/**
 * Test unitaire de UserDetailServiceImpl
 * 
 * @author excilys
 * 
 *         //
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:/services-config.xml")
public class UserDetailServiceImplTest {

	@Mock
	private IPersonDao personDao;
	@InjectMocks
	private UserDetailsServiceImpl userDetailsService;

	/**
	 * Vérifie si un utilisateur existant est bien recuperé
	 */
	@Test
	public void testExistingUser() {
		UserDetails user = new User("foo", "bar", new ArrayList<GrantedAuthority>());
		when(personDao.findUserDetailsByUsername("foo")).thenReturn(user);
		UserDetails result = userDetailsService.loadUserByUsername("foo");
		assertNotNull(result);
	}

	/**
	 * Vérifie si un utilisateur inexistant lève bien l'exception demandée par l'interface
	 */
	@Test(expected = UsernameNotFoundException.class)
	public void testNotExistingUser() {
		when(personDao.findUserDetailsByUsername("foo")).thenReturn(null);
		userDetailsService.loadUserByUsername("foo");
	}

	/**
	 * Vérifie si un utilisateur existant est bien recuperé
	 */
	@Test
	public void testReturnedUser() {
		UserDetails user = new User("foo", "bar", new ArrayList<GrantedAuthority>());
		when(personDao.findUserDetailsByUsername("foo")).thenReturn(user);
		UserDetails result = userDetailsService.loadUserByUsername("foo");
		assertEquals(user.getUsername(), result.getUsername());
		assertEquals(user.getPassword(), result.getPassword());
	}
}
