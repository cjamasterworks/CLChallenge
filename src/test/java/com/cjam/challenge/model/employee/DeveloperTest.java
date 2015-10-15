package com.cjam.challenge.model.employee;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class DeveloperTest {

	@Test
	public void testDeveloper() {
		assertThat(new Developer(123, 1), instanceOf(Developer.class));
	}

	@Test
	public void testGetAllocationAmount() {
		assertThat(new Developer(123, 1).getAllocationAmount(), equalTo(new BigDecimal("1000.00")));
	}

}
