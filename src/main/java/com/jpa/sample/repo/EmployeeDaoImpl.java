package com.jpa.sample.repo;

import com.jpa.sample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for employee
 *
 * @author sam
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

  /**
   * EntityManagerFactory for data base connection.
   */
  private EntityManagerFactory entityManagerFactory;

  @Autowired
  public EmployeeDaoImpl(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  @Override
  public void createEmployees(List<Employee> employeeList) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    int batchSize = 25;
    for (int i = 0; i < employeeList.size(); i++) {
      if (i > 0 && i % batchSize == 0) {
        entityManager.flush();
        entityManager.clear();
      }
      entityManager.persist(employeeList.get(i));
    }
    //Committing the transaction after all insertion.
    transaction.commit();
  }

  @Override
  public List<Employee> selectEmployees() {
    List<Employee> employeeList = new ArrayList<>();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Query query = entityManager.createNativeQuery(
        "SELECT id,date_created,action_date,'Sample' as listSource FROM employee",
        "resultSetMapping");
    for (Object resultMap : query.getResultList()) {
      Object[] objectConsistEmployeeAndNonTransientField = (Object[]) resultMap;
      Employee employee = (Employee) objectConsistEmployeeAndNonTransientField[0];
      employee.setListSource((String) objectConsistEmployeeAndNonTransientField[1]);
      employeeList.add(employee);
    }
    return employeeList;
  }

}
