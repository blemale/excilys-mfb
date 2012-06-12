package com.ebi.formation.mfb.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
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

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.dao.IOperationTypeDao;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.entities.OperationType;
import com.ebi.formation.mfb.entities.OperationType.Type;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.RollbackTransactionalDataSetTestExecutionListener;

/**
 * Test unitaire de OperationDao
 * 
 * @author kpogorzelski
 * @author tbakir
 * @author fguillain
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
	@Autowired
	private ICompteDao compteDao;
	@Autowired
	private IOperationTypeDao operationTypeDao;

	/**
	 * Test somme des opérations carte pour un mois donné
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindTotalOperationsCartes() {
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		BigDecimal total = operationDao.findTotalOperationsCarteByMonth(1, date, datePlusUnMois);
		assertEquals(0, total.compareTo(new BigDecimal(4300)));
	}

	/**
	 * Test nombre d'opérations carte pour un mois donné
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindNumberOfOperationsCarteByMonth() {
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		long total = operationDao.findNumberOfOperationsCarteByMonth(1, date, datePlusUnMois);
		assertEquals(22, total);
	}

	/**
	 * Test nombre d'opérations non carte pour un mois donné
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindNumberOfOperationsWithoutCarteByMonth() {
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		long total = operationDao.findNumberOfOperationsWithoutCarteByMonth(1, date, datePlusUnMois);
		assertEquals(21, total);
	}

	/**
	 * Test liste des opérations non carte pour un mois et un offset donnés
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindOperationsWithoutCartesByMonthPaginated() {
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> operations = operationDao.findOperationsWithoutCarteByMonthPaginated(1, date, datePlusUnMois,
				0, 20);
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
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> operations = operationDao.findOperationsWithoutCarteByMonthPaginated(1, date, datePlusUnMois,
				20, 20);
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
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> operations = operationDao.findOperationsCarteByMonthPaginated(1, date, datePlusUnMois, 0, 20);
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
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> operations = operationDao.findOperationsCarteByMonthPaginated(1, date, datePlusUnMois, 20, 20);
		BigDecimal i = new BigDecimal(0);
		for (Operation operation : operations) {
			i = i.add(operation.getMontant());
		}
		assertEquals(0, i.compareTo(new BigDecimal(400)));
	}

	/**
	 * 
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindVirementsByMonthPaginated() {
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> operations = operationDao.findVirementsByMonthPaginated(2L, date, datePlusUnMois, 0, 20);
		BigDecimal i = new BigDecimal(0);
		for (Operation operation : operations) {
			i = i.add(operation.getMontant());
			assertEquals(OperationType.Type.VIREMENT.name(), operation.getType().getLabel().name());
		}
		assertEquals(0, i.compareTo(new BigDecimal(1600)));
		assertEquals(2, operations.size());
	}

	/**
	 * 
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testFindNumberOfVirementsByMonth() {
		DateTime date = new DateTime(2012, 5, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		long result = operationDao.findNumberOfVirementsByMonth(2L, date, datePlusUnMois);
		assertEquals(2, result);
	}

	/**
	 * 
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testSaveOperation() {
		DateTime date = DateTime.now();
		DateTime datePlusUnMois = date.plusMonths(1);
		long nbVirement = operationDao.findNumberOfVirementsByMonth(2L, date, datePlusUnMois);
		Operation operation = new Operation();
		operation.setCompte(compteDao.findCompteById(2L));
		operation.setDateEffet(date);
		operation.setDateValeur(date);
		operation.setLabel("Ceci est un nouveau virement");
		operation.setMontant(new BigDecimal(130.0));
		operation.setType(operationTypeDao.getOperationTypeByType(Type.VIREMENT));
		operationDao.save(operation);
		long result = operationDao.findNumberOfVirementsByMonth(2L, date, datePlusUnMois);
		assertEquals(nbVirement + 1, result);
	}

	/**
	 * Test la mise à jour d'un compte par rapport aux operations effecutées
	 */
	@DataSet("dataSet-OperationDaoTest.xml")
	@Test
	public void testUpdateCompte() {
		operationDao.updateCompteWithNewOperations();
		assertEquals(0, compteDao.findMontantCompteById(1L).compareTo(new BigDecimal(100)));
		assertEquals(0, compteDao.findEncoursCarteCompteById(1L).compareTo(new BigDecimal(-100)));
		DateTime date = new DateTime(2012, 6, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> l = operationDao.findAllOperationsByMonthByCompte(1L, date, datePlusUnMois);
		for (Operation o : l) {
			assertTrue(o.getOperationDone());
		}
	}
}
