package com.cjam.challenge.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cjam.challenge.model.employee.IEmployee;

/**
 * Implementation for IAllocationService.
 * 
 * @author Christopher J. Jones
 *
 */
@Service
public class AllocationService implements IAllocationService {

	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getTotalAllocationForEmployeeInclSelf(IEmployee emp) {
		return emp.getTotalAllocationAmountForSelfAndReports();
	}

	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getTotalAllocationForDepartmentId(int departmentId, List<IEmployee> allEmployees) {
		// Obtaining employees belonging to a department should not be a feature of an employee, so create a flat level
		// list first.

		List<IEmployee> flatLevelList = new ArrayList<IEmployee>();

		BigDecimal runningTotal = BigDecimal.ZERO;

		for (IEmployee emp : allEmployees) {
			flatLevelList.add(emp);
			flatLevelList.addAll(emp.getAllReports());
		}

		for (IEmployee emp : flatLevelList) {
			if (emp.getDepartmentId() == departmentId) {
				runningTotal = runningTotal.add(emp.getAllocationAmount());
			}
		}
		return runningTotal;
	}

}
