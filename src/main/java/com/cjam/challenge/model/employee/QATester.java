package com.cjam.challenge.model.employee;

import java.math.BigDecimal;

/**
 * Implementation for QATester employee type.
 * 
 * @author Christopher J. Jones
 */
public class QATester extends EmployeeImpl {
	/**
	 * Constructor.
	 * 
	 * @param employeeId Employee ID.
	 * @param departmentId Department Id.
	 */
	public QATester(int employeeId, int departmentId) {
		super(employeeId, departmentId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getAllocationAmount() {
		return new BigDecimal("500.00");
	}

}
