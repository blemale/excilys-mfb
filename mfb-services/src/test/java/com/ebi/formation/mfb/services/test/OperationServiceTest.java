package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.ebi.formation.mfb.dao.ICompteDao;
import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.dao.IOperationTypeDao;
import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.entities.OperationType;
import com.ebi.formation.mfb.entities.OperationType.Type;
import com.ebi.formation.mfb.services.IOperationService.ReturnCodeVirement;
import com.ebi.formation.mfb.services.impl.OperationService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:/services-config.xml")
public class OperationServiceTest {

	@Mock
	IOperationDao operationDao;
	@Mock
	IOperationTypeDao operationTypeDao;
	@Mock
	ICompteDao compteDao;
	@InjectMocks
	OperationService operationService;

	@Test
	public void testGetTotalOperationsCarteByMonthWithOperation() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findTotalOperationsCarteByMonth(1, date, datePlusUnMois)).thenReturn(new BigDecimal(1));
		when(operationDao.findNumberOfOperationsCarteByMonth(1, date, datePlusUnMois)).thenReturn(2L);
		assertEquals(0, operationService.getTotalOperationsCarteByMonth(1, 1, 2012).compareTo(new BigDecimal(1)));
	}

	@Test
	public void testGetTotalOperationsCarteByMonthWithoutOperation() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfOperationsCarteByMonth(1, date, datePlusUnMois)).thenReturn(0L);
		assertEquals(null, operationService.getTotalOperationsCarteByMonth(1, 1, 2012));
	}

	@Test
	public void testGetNumbreOfOperationsCarteByMonth() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfOperationsCarteByMonth(1, date, datePlusUnMois)).thenReturn(42L);
		assertEquals(42L, operationService.getNumberOfOperationsCarteByMonth(1, 1, 2012));
	}

	@Test
	public void testGetNumbreOfOperationsWhithoutCarteByMonth() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, date, datePlusUnMois)).thenReturn(42L);
		assertEquals(42L, operationService.getNumberOfOperationsWithoutCarteByMonth(1, 1, 2012));
	}

	@Test
	public void testGetNumbreOfVirementByMonth() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfVirementsByMonth(0L, date, datePlusUnMois)).thenReturn(42L);
		assertEquals(42L, operationService.getNumberOfVirementByMonth(0L, 1, 2012));
	}

	@Test
	public void testGetOperationsWithoutCarteByMonthPaginated() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsWithoutCarteByMonthPaginated(1, date, datePlusUnMois, 0, 20))
				.thenReturn(result);
		assertEquals(result, operationService.getOperationsWithoutCarteByMonthPaginated(1, 1, 2012, 0, 20));
	}

	@Test
	public void testGetOperationsWithoutCarteByMonthPaginatedWithPage() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsWithoutCarteByMonthPaginated(1, date, datePlusUnMois, 0, 20))
				.thenReturn(result);
		assertEquals(result, operationService.getOperationsWithoutCarteByMonthPaginated(1, 1, 2012, 0));
	}

	@Test
	public void testGetOperationsCarteByMonthPaginated() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsCarteByMonthPaginated(1, date, datePlusUnMois, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getOperationsCarteByMonthPaginated(1, 1, 2012, 0, 20));
	}

	@Test
	public void testGetVirementsByMonthPaginated() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findVirementsByMonthPaginated(0L, date, datePlusUnMois, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getVirementsByMonthPaginated(0L, 1, 2012, 0, 20));
	}

	@Test
	public void testGetOperationsCarteByMonthPaginatedWithPage() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsCarteByMonthPaginated(1, date, datePlusUnMois, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getOperationsCarteByMonthPaginated(1, 1, 2012, 0));
	}

	@Test
	public void testGetNumberOfPagesForOperationsWithoutCartesByMonth() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, date, datePlusUnMois)).thenReturn(400L);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(2, date, datePlusUnMois)).thenReturn(410L);
		assertEquals(20, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(1, 1, 2012));
		assertEquals(21, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(2, 1, 2012));
	}

	@Test
	public void testGetNumberOfPagesForOperationsWithoutCartesByMonthWithCustom() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, date, datePlusUnMois)).thenReturn(600L);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(2, date, datePlusUnMois)).thenReturn(620L);
		assertEquals(20, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(1, 1, 2012, 30));
		assertEquals(21, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(2, 1, 2012, 30));
	}

	@Test
	public void testGetNumberOfPagesForOperationsCartesByMonth() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfOperationsCarteByMonth(1, date, datePlusUnMois)).thenReturn(400L);
		when(operationDao.findNumberOfOperationsCarteByMonth(2, date, datePlusUnMois)).thenReturn(410L);
		assertEquals(20, operationService.getNumberOfPagesForOperationsCartesByMonth(1, 1, 2012));
		assertEquals(21, operationService.getNumberOfPagesForOperationsCartesByMonth(2, 1, 2012));
	}

	@Test
	public void testGetNumberOfPagesForOperationsCartesByMonthWithCustom() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, date, datePlusUnMois)).thenReturn(900L);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(2, date, datePlusUnMois)).thenReturn(925L);
		assertEquals(30, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(1, 1, 2012, 30));
		assertEquals(31, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(2, 1, 2012, 30));
	}

	@Test
	public void testGetNumberOfPagesForVirementByMonth() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfVirementsByMonth(0L, date, datePlusUnMois)).thenReturn(400L);
		when(operationDao.findNumberOfVirementsByMonth(1L, date, datePlusUnMois)).thenReturn(410L);
		assertEquals(20, operationService.getNumberOfPagesForVirementByMonth(0L, 1, 2012));
		assertEquals(21, operationService.getNumberOfPagesForVirementByMonth(1L, 1, 2012));
	}

	@Test
	public void testGetNumberOfPagesForVirementByMonthWithCustom() {
		DateTime date = new DateTime(2012, 1, 1, 0, 0);
		DateTime datePlusUnMois = date.plusMonths(1);
		when(operationDao.findNumberOfVirementsByMonth(0L, date, datePlusUnMois)).thenReturn(900L);
		when(operationDao.findNumberOfVirementsByMonth(1L, date, datePlusUnMois)).thenReturn(925L);
		assertEquals(30, operationService.getNumberOfPagesForVirementByMonth(0L, 1, 2012, 30));
		assertEquals(31, operationService.getNumberOfPagesForVirementByMonth(1L, 1, 2012, 30));
	}

	@Test
	public void testVirementInterneOk() {
		Compte compteADebiter = new Compte();
		compteADebiter.setId(0L);
		compteADebiter.setSolde(new BigDecimal(300));
		Compte compteACrediter = new Compte();
		compteACrediter.setId(1L);
		compteACrediter.setSolde(new BigDecimal(400));
		when(operationTypeDao.getOperationTypeByType(Type.VIREMENT)).thenReturn(new OperationType());
		when(compteDao.findCompteById(0)).thenReturn(compteADebiter);
		when(compteDao.findCompteById(1)).thenReturn(compteACrediter);
		ReturnCodeVirement result = operationService.doVirement(0L, 1L, "", new BigDecimal(200));
		assertEquals(ReturnCodeVirement.OK, result);
		assertEquals(0, compteADebiter.getSolde().compareTo(new BigDecimal(100)));
		assertEquals(0, compteACrediter.getSolde().compareTo(new BigDecimal(600)));
	}

	@Test
	public void testVirementExterneOk() {
		Compte compteADebiter = new Compte();
		compteADebiter.setId(0L);
		compteADebiter.setSolde(new BigDecimal(300));
		Compte compteACrediter = new Compte();
		compteACrediter.setId(1L);
		compteACrediter.setSolde(new BigDecimal(400));
		when(operationTypeDao.getOperationTypeByType(Type.VIREMENT)).thenReturn(new OperationType());
		when(compteDao.findCompteByNumeroCompte("foo")).thenReturn(compteACrediter);
		when(compteDao.findCompteById(0)).thenReturn(compteADebiter);
		when(compteDao.findCompteById(1)).thenReturn(compteACrediter);
		ReturnCodeVirement result = operationService.doVirement(0L, "foo", "", new BigDecimal(200));
		assertEquals(ReturnCodeVirement.OK, result);
		assertEquals(0, compteADebiter.getSolde().compareTo(new BigDecimal(100)));
		assertEquals(0, compteACrediter.getSolde().compareTo(new BigDecimal(600)));
	}

	@Test
	public void testVirementComptesIdentiques() {
		Compte compteADebiter = new Compte();
		compteADebiter.setId(0L);
		ReturnCodeVirement result = operationService.doVirement(0L, 0L, "", new BigDecimal(200));
		assertEquals(ReturnCodeVirement.IDENTICAL_COMPTES, result);
	}

	@Test
	public void testVirementDecouvert() {
		Compte compteADebiter = new Compte();
		compteADebiter.setId(0L);
		compteADebiter.setSolde(new BigDecimal(100));
		Compte compteACrediter = new Compte();
		compteACrediter.setId(1L);
		compteACrediter.setSolde(new BigDecimal(400));
		when(compteDao.findCompteById(0)).thenReturn(compteADebiter);
		when(compteDao.findCompteById(1)).thenReturn(compteACrediter);
		ReturnCodeVirement result = operationService.doVirement(0L, 1L, "", new BigDecimal(200));
		assertEquals(ReturnCodeVirement.DECOUVERT, result);
	}

	@Test
	public void testVirementCompteDebitNonExistant() {
		Compte compteACrediter = new Compte();
		compteACrediter.setId(1L);
		compteACrediter.setSolde(new BigDecimal(400));
		when(compteDao.findCompteById(0)).thenReturn(null);
		when(compteDao.findCompteById(1)).thenReturn(compteACrediter);
		ReturnCodeVirement result = operationService.doVirement(0L, 1L, "", new BigDecimal(200));
		assertEquals(ReturnCodeVirement.COMPTE_DEBIT_INEXISTANT, result);
	}

	@Test
	public void testVirementCompteCreditNonExistant() {
		Compte compteADebiter = new Compte();
		compteADebiter.setId(0L);
		compteADebiter.setSolde(new BigDecimal(100));
		when(compteDao.findCompteById(0)).thenReturn(compteADebiter);
		when(compteDao.findCompteById(1)).thenReturn(null);
		ReturnCodeVirement result = operationService.doVirement(0L, 1L, "", new BigDecimal(200));
		assertEquals(ReturnCodeVirement.COMPTE_CREDIT_INEXISTANT, result);
	}

	@Test
	public void testVirementExterneCompteCreditNonExistant() {
		Compte compteADebiter = new Compte();
		compteADebiter.setId(0L);
		compteADebiter.setSolde(new BigDecimal(100));
		when(compteDao.findCompteByNumeroCompte("foo")).thenReturn(null);
		ReturnCodeVirement result = operationService.doVirement(0L, "foo", "", new BigDecimal(200));
		assertEquals(ReturnCodeVirement.COMPTE_CREDIT_INEXISTANT, result);
	}

	@Test
	public void testVirementValeurMontant() {
		ReturnCodeVirement result = operationService.doVirement(0L, 1L, "", new BigDecimal(-200));
		assertEquals(ReturnCodeVirement.MONTANT_INCORRECT, result);
		ReturnCodeVirement result2 = operationService.doVirement(0L, 1L, "", new BigDecimal(0));
		assertEquals(ReturnCodeVirement.MONTANT_INCORRECT, result2);
	}
}
