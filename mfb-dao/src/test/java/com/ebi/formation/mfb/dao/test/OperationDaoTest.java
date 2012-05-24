package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
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

import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.entities.Operation;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.RollbackTransactionalDataSetTestExecutionListener;

/**
 * Test unitaire de OperationDao
 * 
 * @author kpogorzelski
 * @author tbakir
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:persistence-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		RollbackTransactionalDataSetTestExecutionListener.class, TransactionalTestExecutionListener.class, })
@TransactionConfiguration
@Transactional
public class OperationDaoTest {

	@Autowired
	private IOperationDao operationDao;

	/**
	 * Test somme des opérations carte pour un mois donné
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindTotalOperationsCartes() {
		BigDecimal total = operationDao.findTotalOperationsCarteByMonth(1, 5, 2012);
		assertEquals(0, total.compareTo(new BigDecimal(4300)));
	}

	/**
	 * Test nombre d'opérations carte pour un mois donné
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testfindNumberOfOperationsCarteByMonth() {
		long total = operationDao.findNumbreOfOperationsCarteByMonth(1, 5, 2012);
		assertEquals(22, total);
	}

	/**
	 * Test liste des opérations non carte pour un mois et un offset donnés
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindOperationsWithoutCartesByMonthPaginated() {
		List<Operation> operations = operationDao.findOperationsWithoutCarteByMonthPaginated(1, 5, 2012, 0);
		BigDecimal i = new BigDecimal(0);
		for (Operation operation : operations) {
			i = i.add(operation.getMontant());
		}
		assertEquals(0, i.compareTo(new BigDecimal(15600)));
	}

	/**
	 * Test liste des opérations non carte pour un mois et un offset donnés
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindOperationsWithoutCartesByMonthPaginatedUn() {
		List<Operation> operations = operationDao.findOperationsWithoutCarteByMonthPaginated(1, 5, 2012, 1);
		BigDecimal i = new BigDecimal(0);
		for (Operation operation : operations) {
			i = i.add(operation.getMontant());
		}
		assertEquals(0, i.compareTo(new BigDecimal(800)));
	}

	/**
	 * Test liste des opérations cartes pour un mois et un offset donnés
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindOperationsCarteByMonthPaginated() {
		List<Operation> operations = operationDao.findOperationsCarteByMonthPaginated(1, 5, 2012, 0);
		BigDecimal i = new BigDecimal(0);
		for (Operation operation : operations) {
			i = i.add(operation.getMontant());
		}
		assertEquals(0, i.compareTo(new BigDecimal(3900)));
	}

	/**
	 * Test liste des opérations cartes pour un mois et un offset donnés
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindOperationsCarteByMonthPaginatedUn() {
		List<Operation> operations = operationDao.findOperationsCarteByMonthPaginated(1, 5, 2012, 1);
		BigDecimal i = new BigDecimal(0);
		for (Operation operation : operations) {
			i = i.add(operation.getMontant());
		}
		assertEquals(0, i.compareTo(new BigDecimal(400)));
	}
}
