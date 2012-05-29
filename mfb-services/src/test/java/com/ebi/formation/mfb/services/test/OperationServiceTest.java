package com.ebi.formation.mfb.services.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		when(operationDao.findTotalOperationsCarteByMonth(1, 1, 2012)).thenReturn(new BigDecimal(1));
		when(operationDao.findNumberOfOperationsCarteByMonth(1, 1, 2012)).thenReturn(2L);
		assertEquals(0, operationService.getTotalOperationsCarteByMonth(1, 1, 2012).compareTo(new BigDecimal(1)));
	}

	@Test
	public void testGetTotalOperationsCarteByMonthWithoutOperation() {
		when(operationDao.findNumberOfOperationsCarteByMonth(1, 1, 2012)).thenReturn(0L);
		assertEquals(null, operationService.getTotalOperationsCarteByMonth(1, 1, 2012));
	}

	@Test
	public void testGetNumbreOfOperationsCarteByMonth() {
		when(operationDao.findNumberOfOperationsCarteByMonth(1, 1, 2012)).thenReturn(42L);
		assertEquals(42L, operationService.getNumberOfOperationsCarteByMonth(1, 1, 2012));
	}

	@Test
	public void testGetNumbreOfOperationsWhithoutCarteByMonth() {
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, 1, 2012)).thenReturn(42L);
		assertEquals(42L, operationService.getNumberOfOperationsWithoutCarteByMonth(1, 1, 2012));
	}

	@Test
	public void testGetOperationsWithoutCarteByMonthPaginated() {
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsWithoutCarteByMonthPaginated(1, 1, 2012, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getOperationsWithoutCarteByMonthPaginated(1, 1, 2012, 0, 20));
	}

	@Test
	public void testGetOperationsWithoutCarteByMonthPaginatedWithPage() {
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsWithoutCarteByMonthPaginated(1, 1, 2012, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getOperationsWithoutCarteByMonthPaginated(1, 1, 2012, 0));
	}

	@Test
	public void testGetOperationsCarteByMonthPaginated() {
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsCarteByMonthPaginated(1, 1, 2012, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getOperationsCarteByMonthPaginated(1, 1, 2012, 0, 20));
	}

	@Test
	public void testGetOperationsCarteByMonthPaginatedWithPage() {
		List<Operation> result = new ArrayList<Operation>();
		result.add(new Operation());
		when(operationDao.findOperationsCarteByMonthPaginated(1, 1, 2012, 0, 20)).thenReturn(result);
		assertEquals(result, operationService.getOperationsCarteByMonthPaginated(1, 1, 2012, 0));
	}

	@Test
	public void testGetNumberOfPagesForOperationsWithoutCartesByMonth() {
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, 1, 2012)).thenReturn(400L);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(2, 1, 2012)).thenReturn(410L);
		assertEquals(20, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(1, 1, 2012));
		assertEquals(21, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(2, 1, 2012));
	}

	@Test
	public void testGetNumberOfPagesForOperationsWithoutCartesByMonthWithCustom() {
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, 1, 2012)).thenReturn(600L);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(2, 1, 2012)).thenReturn(620L);
		assertEquals(20, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(1, 1, 2012, 30));
		assertEquals(21, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(2, 1, 2012, 30));
	}

	@Test
	public void testGetNumberOfPagesForOperationsCartesByMonth() {
		when(operationDao.findNumberOfOperationsCarteByMonth(1, 1, 2012)).thenReturn(400L);
		when(operationDao.findNumberOfOperationsCarteByMonth(2, 1, 2012)).thenReturn(410L);
		assertEquals(20, operationService.getNumberOfPagesForOperationsCartesByMonth(1, 1, 2012));
		assertEquals(21, operationService.getNumberOfPagesForOperationsCartesByMonth(2, 1, 2012));
	}

	@Test
	public void testGetNumberOfPagesForOperationsCartesByMonthWithCustom() {
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(1, 1, 2012)).thenReturn(900L);
		when(operationDao.findNumberOfOperationsWithoutCarteByMonth(2, 1, 2012)).thenReturn(925L);
		assertEquals(30, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(1, 1, 2012, 30));
		assertEquals(31, operationService.getNumberOfPagesForOperationsWithoutCartesByMonth(2, 1, 2012, 30));
	}
}
