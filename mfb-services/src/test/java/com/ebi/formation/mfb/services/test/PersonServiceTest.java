package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.services.IPersonService;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:services-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet("dataSet-PersonServiceTest.xml")
public class PersonServiceTest {

	@Autowired
	private IPersonService personService;

	@Test
	public void testFindPersonByUsername() {
		Person p = personService.findPersonByUsername("toto");
		assertEquals("toto1", p.getFirstName());
		assertEquals("toto2", p.getLastName());
		p = personService.findPersonByUsername("foo");
		assertEquals("foo1", p.getFirstName());
		assertEquals("foo2", p.getLastName());
	}
}
