package com.jpa.sample.repo;

import com.jpa.sample.entity.CompositeKey;
import com.jpa.sample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, CompositeKey> {

  List<Employee> findByActionDateBetween(LocalDateTime date, LocalDateTime after);

  List<Employee> findByActionDateLessThanEqual(LocalDateTime date);

}
