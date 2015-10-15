package com.cjam.challenge.model.employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Employee. Intended to be a superclass for employee sub-types.
 * 
 * @author Christopher J Jones
 */
public class EmployeeImpl implements IEmployee {

	/** Employee ID. */
	private int employeeId;

	/** Department ID. */
	private int departmentId;

	/** List of employees reporting directly to "this" employee. */
	private List<IEmployee> directReports = new ArrayList<IEmployee>();

	/**
	 * Constructor.
	 * 
	 * @param employeeId Employee Id.
	 * @param departmentId Department Id.
	 */
	public EmployeeImpl(int employeeId, int departmentId) {
		this.employeeId = employeeId;
		this.departmentId = departmentId;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IEmployee> getDirectReports() {
		// Return a copy of the list.
		return new ArrayList<IEmployee>(directReports);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IEmployee> getAllReports() {
		List<IEmployee> reportList = new ArrayList<IEmployee>();

		for (IEmployee emp : getDirectReports()) {
			// Add the emp
			reportList.add(emp);
			// Add his/her reports
			reportList.addAll(emp.getAllReports());
		}

		return reportList;
	}

	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getTotalAllocationAmountsForReports() {
		BigDecimal runningTotal = BigDecimal.ZERO;

		for (IEmployee aReport : directReports) {
			runningTotal = runningTotal.add(aReport.getTotalAllocationAmountForSelfAndReports());
		}

		return runningTotal;
	}

	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getTotalAllocationAmountForSelfAndReports() {
		return getAllocationAmount().add(getTotalAllocationAmountsForReports());
	}

	/**
	 * {@inheritDoc}
	 */
	public void addDirectReport(IEmployee employee) {
		directReports.add(employee);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getAllocationAmount() {
		return BigDecimal.ZERO;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getDepartmentId() {
		return departmentId;
	}

}
