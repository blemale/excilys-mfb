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

import com.ebi.formation.mfb.dao.IOperationTypeDao;
import com.ebi.formation.mfb.entities.OperationType;
import com.ebi.formation.mfb.entities.OperationType.Type;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.RollbackTransactionalDataSetTestExecutionListener;

/**
 * Test unitaire de OperationTypeDao
 * 
 * @author fguillain
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:persistence-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		RollbackTransactionalDataSetTestExecutionListener.class, TransactionalTestExecutionListener.class, })
@TransactionConfiguration
@Transactional
public class OperationTypeDaoTest {

	@Autowired
	private IOperationTypeDao operationTypeDao;

	/**
	 * Test la récupération d'une OperationType via un Type
	 */
	@DataSet("dataSet-OperationTypeDaoTest.xml")
	@Test
	public void testGetOperationTypeByType() {
		OperationType ot = operationTypeDao.getOperationTypeByType(OperationType.Type.VIREMENT);
		assertNotNull(ot);
		assertEquals(ot.getLabel(), Type.VIREMENT);
	}

	/**
	 * Test la récupération de toutes les types d'opération
	 */
	@DataSet("dataSet-OperationTypeDaoTest.xml")
	@Test
	public void testFindAllOperationTypes() {
		List<Type> listOperationType = operationTypeDao.findAllOperationTypes();
		assertNotNull(listOperationType);
		assertEquals(4, listOperationType.size());
	}
}
