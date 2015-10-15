package com.cjam.challenge.model.employee;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ManagerTest {

	@Test
	public void testManager() {
		assertThat(new Manager(123, 1), instanceOf(Manager.class));
	}

	@Test
	public void testGetAllocationAmount() {
		assertThat(new Manager(123, 1).getAllocationAmount(), equalTo(new BigDecimal("300.00")));
	}

}
