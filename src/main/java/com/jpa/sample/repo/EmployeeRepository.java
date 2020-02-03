package com.jpa.sample.repo;

import org.springframework.data.repository.CrudRepository;

import com.jpa.sample.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
