package com.jpa.sample.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.sample.entity.Employee;

/**
 * Repository class for employee
 * 
 * @author sam
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public EmployeeDaoImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	/**
	 * This function will store the data into the table specified by entity class.
	 */
	@Override
	public void createEmployees(List<Employee> employees) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		int batchSize = 25;
		for (int i = 0; i < 6; i++) {
			if (i > 0 && i % batchSize == 0) {
				entityManager.flush();
				entityManager.clear();
			}
			entityManager.persist(new Employee(i, LocalDate.now(),LocalDateTime.now()));
		}
		transaction.commit();
	}
}
