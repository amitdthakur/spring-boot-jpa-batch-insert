package com.jpa.sample.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.sample.entity.CompositeKey;
import com.jpa.sample.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, CompositeKey> {

	public List<Employee> findByActionDateBetween(LocalDateTime date, LocalDateTime after); 
	
	
	public List<Employee> findByActionDateLessThanEqual(LocalDateTime date); 
	
}
