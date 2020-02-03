package com.jpa.sample.repo;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.sample.entity.Employee;

@Repository
public class EmployeeDao {

	private Logger logger = LoggerFactory.getLogger(EmployeeDao.class);

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void create() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			int batchSize = 25;
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			for (int i = 0; i < 4; i++) {
				if (i > 0 && i % batchSize == 0) {
					entityManager.flush();
					entityManager.clear();
				}
				entityManager.persist(new Employee(i, LocalDate.now()));
			}
			transaction.commit();
		} catch (Exception e) {
			logger.error("Exception ", e);
		}
	}
}
