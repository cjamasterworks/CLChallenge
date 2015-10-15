package com.cjam.challenge.model.employee;

import java.math.BigDecimal;

/**
 * Implementation for Developer employee type.
 * 
 * @author Christopher J. Jones
 */
public class Developer extends EmployeeImpl {

	/**
	 * Constructor.
	 * 
	 * @param employeeId Employee ID.
	 * @param departmentId Department Id.
	 */
	public Developer(int employeeId, int departmentId) {
		super(employeeId, departmentId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getAllocationAmount() {
		return new BigDecimal("1000.00");
	}

}
