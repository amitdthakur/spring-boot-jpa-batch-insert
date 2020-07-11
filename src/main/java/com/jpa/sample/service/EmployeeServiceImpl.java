package com.jpa.sample.service;

import com.jpa.sample.dao.EmployeeDao;
import com.jpa.sample.entity.Employee;
import com.jpa.sample.repo.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service impl for employee table.
 *
 * @author SAM
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  /**
   * Employee repository object.
   */
  private EmployeeRepository employeeRepository;
  /**
   * Employee dao object.
   */
  private EmployeeDao employeeDao;

  /**
   * Public constructor for auto wiring.
   *
   * @param employeeRepository EmployeeRepository object.
   * @param employeeDao        EmployeeDao object.
   */
  public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeDao
      employeeDao) {
    this.employeeRepository = employeeRepository;
    this.employeeDao = employeeDao;
  }

  @Override
  public void createEmployees(List<Employee> employeeList) {
    employeeDao.createEmployees(employeeList);
  }

  @Transactional
  public void insert(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public List<Employee> selectEmployees() {
    return employeeDao.selectEmployees();
  }

}
