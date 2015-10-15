package com.cjam.challenge.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cjam.challenge.model.employee.IEmployee;
import com.cjam.challenge.testdata.TestData;

@SuppressWarnings("javadoc")
@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AllocationServiceTest {

	@Autowired
	private AllocationService allocationService;

	private static final IEmployee MANAGER_1A = TestData.getScenario1();

	private static final IEmployee MANAGER_2A = TestData.getScenario2();

	/** Main scenario to solve from challenge documentation. */
	private static final IEmployee MANAGER_CHALLENGE = TestData.getChallengeScenario();

	/** Main scenario to solve from challenge documentation. */
	@Test
	public void testGetTotalAllocationForEmployeeInclSelfChallengeScenario() {
		BigDecimal allocAmt = allocationService.getTotalAllocationForEmployeeInclSelf(MANAGER_CHALLENGE);

		assertThat(allocAmt, equalTo(new BigDecimal("2100.00")));
	}

	@Test
	public void testGetTotalAllocationForEmployeeInclSelfScenario1() {

		BigDecimal allocAmt = allocationService.getTotalAllocationForEmployeeInclSelf(MANAGER_1A);

		assertThat(allocAmt, equalTo(new BigDecimal("3900.00")));
	}

	@Test
	public void testGetTotalAllocationForEmployeeInclSelfScenario2() {

		BigDecimal allocAmt = allocationService.getTotalAllocationForEmployeeInclSelf(MANAGER_2A);

		assertThat(allocAmt, equalTo(new BigDecimal("3400.00")));
	}

	@Test
	public void testGetTotalAllocationForDepartmentIdChallengeScenario() {
		List<IEmployee> empList = new ArrayList<IEmployee>();

		empList.add(MANAGER_CHALLENGE);

		BigDecimal allocAmt = allocationService.getTotalAllocationForDepartmentId(1, empList);

		assertThat(allocAmt, equalTo(new BigDecimal("1800.00")));
	}

	@Test
	public void testGetTotalAllocationForDepartmentIdScenario1and2() {
		List<IEmployee> empList = new ArrayList<IEmployee>();
		empList.add(MANAGER_1A);
		empList.add(MANAGER_2A);

		BigDecimal allocAmt = allocationService.getTotalAllocationForDepartmentId(2, empList);

		assertThat(allocAmt, equalTo(new BigDecimal("1600.00")));
	}

	@Test
	public void testGetTotalAllocationForDepartmentIdScenario2() {
		List<IEmployee> empList = new ArrayList<IEmployee>();

		empList.add(MANAGER_2A);

		BigDecimal allocAmt = allocationService.getTotalAllocationForDepartmentId(2, empList);

		assertThat(allocAmt, equalTo(new BigDecimal("300.00")));
	}

}
