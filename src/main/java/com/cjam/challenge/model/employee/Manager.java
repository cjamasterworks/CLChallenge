package com.cjam.challenge.model.employee;

import java.math.BigDecimal;

/**
 * Implementation for Manager employee type.
 * 
 * @author Christopher J. Jones
 */
public class Manager extends EmployeeImpl {

	/**
	 * Constructor.
	 * 
	 * @param employeeId Employee ID.
	 * @param departmentId Department Id.
	 */
	public Manager(int employeeId, int departmentId) {
		super(employeeId, departmentId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getAllocationAmount() {
		return new BigDecimal("300.00");
	}

}
