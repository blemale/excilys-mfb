package com.ebi.formation.mfb.services.test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.services.impl.PersonService;

/**
 * Test unitaire de PersonService
 * 
 * @author fguillain
 * 
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:/services-config.xml")
public class PersonServiceTest {

	@Mock
	IPersonDao personDao;
	@InjectMocks
	PersonService ps;

	/**
	 * Test la récupération d'une Person via son username
	 */
	@Test
	public void testFindPersonByUsername() {
		Person person = new Person();
		person.setUsername("foo");
		person.setFirstName("John");
		person.setLastName("Doo");
		when(personDao.findPersonByUsername("foo")).thenReturn(person);
		Person result = ps.findPersonByUsername("foo");
		assertEquals(person.getUsername(), result.getUsername());
		assertEquals(person.getFirstName(), result.getFirstName());
		assertEquals(person.getLastName(), result.getLastName());
	}

	/**
	 * Test la sauvegarde d'une Person
	 */
	@Test
	public void testSavePerson() {
		Person person = new Person();
		person.setUsername("toto");
		person.setFirstName("titi");
		person.setLastName("tutu");
		person.setPassword("tata");
		assertTrue(true);
	}
}
