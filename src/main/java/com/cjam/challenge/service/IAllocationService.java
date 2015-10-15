package com.cjam.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import com.cjam.challenge.model.employee.IEmployee;

/**
 * Service that analyzes an employee model and returns specific data.
 * 
 * @author Christopher J. Jones
 */
public interface IAllocationService {
	/**
	 * Gets the total allocation for an employee including self.
	 * 
	 * @param emp Employee Instance to analyze.
	 * 
	 * @return total allocation amount for an employee including self.
	 */
	public BigDecimal getTotalAllocationForEmployeeInclSelf(IEmployee emp);

	/**
	 * Gets the total allocation amount for a specified department.<br>
	 * <br>
	 * DEV NOTE TO REVIEWER: Normally I would expect data to come from a database. For this challenge, I am expecting
	 * the data just to be passed in as a list of employees, each of which can have their own hierarchy of direct
	 * reports. Only top level elements need be passed in.
	 * 
	 * @param departmentId department id for which to retrieve allocation amount.
	 * @param allEmployees list of all employees.
	 * 
	 * @return the total allocation amount for a specified department.
	 */
	public BigDecimal getTotalAllocationForDepartmentId(int departmentId, List<IEmployee> allEmployees);
}
