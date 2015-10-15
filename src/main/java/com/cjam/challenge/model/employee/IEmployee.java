package com.cjam.challenge.model.employee;

import java.math.BigDecimal;
import java.util.List;

/**
 * Employee Interface.
 * 
 * @author Christopher J Jones
 */
public interface IEmployee {

	/**
	 * Get allocation amount for the given employee type.<br>
	 * <br>
	 * NOTE TO REVIEWER: I would normally expect allocation amounts to be obtained from a configurable source (such as
	 * DB) and initialized from that source. For the purposes of this challenge, I have hardcoded the amounts in
	 * implementation classes.
	 * 
	 * @return allocation amount.
	 */
	public BigDecimal getAllocationAmount();

	/**
	 * Get list of direct reports.
	 * 
	 * @return list of direct reports.
	 */
	public List<IEmployee> getDirectReports();

	/**
	 * Gets the full list of direct and sub-reports.
	 * 
	 * @return the full list of direct and sub-reports.
	 */
	public List<IEmployee> getAllReports();

	/**
	 * Gets sum of allocation amounts for employees reporting to a given employee.
	 * 
	 * @return sum of allocation amounts for employees reporting to a given employee.
	 */
	public BigDecimal getTotalAllocationAmountsForReports();

	/**
	 * Gets sum of allocation amounts for employees reporting to a given employee in addition to allocation amount for
	 * the employee himself/herself.
	 * 
	 * @return sum of allocation amounts for employees reporting to a given employee.
	 */
	public BigDecimal getTotalAllocationAmountForSelfAndReports();

	/**
	 * Gets the employee ID.
	 * 
	 * @return the employee ID.
	 */
	public int getEmployeeId();

	/**
	 * Gets the department ID.
	 * 
	 * @return the department ID.
	 */
	public int getDepartmentId();

	/**
	 * Add a direct report to the Employee.
	 * 
	 * @param emp the employee you are adding as a direct report.
	 */
	public void addDirectReport(IEmployee emp);
}
