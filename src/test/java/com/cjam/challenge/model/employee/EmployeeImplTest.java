package com.cjam.challenge.model.employee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;

import java.math.BigDecimal;

import org.junit.Test;

import com.cjam.challenge.testdata.TestData;

@SuppressWarnings({ "javadoc", "boxing" })
public class EmployeeImplTest {
	private static IEmployee manager1A = TestData.getScenario1();
	private static IEmployee manager2A = TestData.getScenario2();

	@Test
	public void testEmployeeImpl() {
		EmployeeImpl anEmpl = new EmployeeImpl(123, 1);
		assertThat(anEmpl, instanceOf(EmployeeImpl.class));
	}

	@Test
	public void testGetDirectReportsScenario1() {
		assertThat(manager1A.getDirectReports(), hasSize(2));
	}

	@Test
	public void testGetDirectReportsScenario2() {
		assertThat(manager2A.getDirectReports(), hasSize(3));
	}

	@Test
	public void testGetAllReportsScenario1() {
		assertThat(manager1A.getAllReports(), hasSize(6));
	}

	@Test
	public void testGetAllReportsScenario2() {
		assertThat(manager2A.getAllReports(), hasSize(5));
	}

	@Test
	public void testGetTotalAllocationAmountsForReportsScenario1() {
		assertThat(manager1A.getTotalAllocationAmountsForReports(), equalTo(new BigDecimal("3600.00")));
	}

	@Test
	public void testGetTotalAllocationAmountsForReportsScenario2() {
		assertThat(manager2A.getTotalAllocationAmountsForReports(), equalTo(new BigDecimal("3100.00")));
	}

	@Test
	public void testGetTotalAllocationAmountForSelfAndReportsScenario1() {
		assertThat(manager1A.getTotalAllocationAmountForSelfAndReports(), equalTo(new BigDecimal("3900.00")));
	}

	@Test
	public void testGetTotalAllocationAmountForSelfAndReportsScenario2() {
		assertThat(manager2A.getTotalAllocationAmountForSelfAndReports(), equalTo(new BigDecimal("3400.00")));
	}

	@Test
	public void testAddDirectReport() {
		Manager aManager = new Manager(224, 2);

		assertThat(aManager.getDirectReports(), hasSize(0));

		aManager.addDirectReport(new Developer(333, 3));

		assertThat(aManager.getDirectReports(), hasSize(1));
	}

	@Test
	public void testGetEmployeeId() {
		assertThat(manager1A.getEmployeeId(), equalTo(234));
	}

	@Test
	public void testGetAllocationAmount() {
		assertThat(new EmployeeImpl(123, 1).getAllocationAmount(), equalTo(BigDecimal.ZERO));
	}

	@Test
	public void testGetDepartmentId() {
		assertThat(manager1A.getDepartmentId(), equalTo(2));
	}

}
