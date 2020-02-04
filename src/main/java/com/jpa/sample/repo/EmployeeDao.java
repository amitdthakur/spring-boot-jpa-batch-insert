package com.jpa.sample.repo;

import java.util.List;

import com.jpa.sample.entity.Employee;

public interface EmployeeDao {
	/**
	 * This function will create the employee.
	 */
	void createEmployees(List<Employee> employees);
}
