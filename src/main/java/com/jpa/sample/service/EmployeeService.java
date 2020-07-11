package com.jpa.sample.service;

import com.jpa.sample.entity.Employee;
import java.util.List;

/**
 * Employee service.
 *
 * @author SAM
 */
public interface EmployeeService {

  /**
   * This function will create the employees from the list.
   *
   * @param employeeList Employee list to be inserted.
   */
  void createEmployees(List<Employee> employeeList);

  /**
   * This function will return list of employee objects.
   *
   * @return List of employee objects,
   */
  List<Employee> selectEmployees();
}
