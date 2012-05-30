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

import com.ebi.formation.mfb.dao.IOperationDao;
import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.services.impl.OperationService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:/services-config.xml")
public class OperationServiceTest {

	@Mock
	IOperationDao operationDao;
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
		when(operationDao.findVirementsByMonthPaginated("foo", date, datePlusUnMois, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getVirementsByMonthPaginated("foo", 1, 2012, 0, 20));
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
}
