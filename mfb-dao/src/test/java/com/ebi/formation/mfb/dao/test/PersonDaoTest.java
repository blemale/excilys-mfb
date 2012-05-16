package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.ebi.formation.mfb.dao.IPersonDao;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:persistence-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet("dataSet-PersonDaoTest.xml")
public class PersonDaoTest {

	@Autowired
	private IPersonDao personDao;

	@Test
	public void testExistingPerson() {
		UserDetails totoExists = personDao.findUserDetailsByUsername("toto");
		assertNotNull(totoExists);
	}

	@Test
	public void testNotExistingPerson() {
		UserDetails titiDoesntExist = personDao.findUserDetailsByUsername("titi");
		assertNull(titiDoesntExist);
	}
}
