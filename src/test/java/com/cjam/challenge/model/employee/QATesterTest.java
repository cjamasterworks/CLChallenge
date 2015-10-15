package com.cjam.challenge.model.employee;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class QATesterTest {

	@Test
	public void testQATester() {
		assertThat(new QATester(123, 1), instanceOf(QATester.class));
	}

	@Test
	public void testGetAllocationAmount() {
		assertThat(new QATester(123, 1).getAllocationAmount(), equalTo(new BigDecimal("500.00")));
	}

}
