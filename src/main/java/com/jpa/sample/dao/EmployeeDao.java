package com.jpa.sample.dao;

import com.jpa.sample.entity.Employee;
import java.util.List;

/**
 * Dao impl for employee table.
 *
 * @author SAM
 */
public interface EmployeeDao {

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
