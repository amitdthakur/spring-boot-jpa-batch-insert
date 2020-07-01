package com.jpa.sample;

import com.jpa.sample.repo.EmployeeDao;
import com.jpa.sample.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

  /**
   * Logger instance
   */
  private Logger logger = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
  /**
   * Employee dao object.
   */
  private EmployeeDao employeeDao;
  /**
   * Employee repository object.
   */
  private EmployeeRepository employeeRepository;

  @Autowired
  public SpringBootConsoleApplication(EmployeeDao employeeDao,
      EmployeeRepository employeeRepository) {
    this.employeeDao = employeeDao;
    this.employeeRepository = employeeRepository;
  }

  /**
   * Entry point for the application
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) throws Exception {
    SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info(".....Application started...");
    //List<Employee> employeeList = new ArrayList<>();
    //employeeList.add(new Employee(1, LocalDate.now(), LocalDateTime.now(), null));
    //employeeDao.createEmployees(employeeList);
    //Select statement on the data base
    logger.info("Select result {} ", employeeDao.selectEmployees());
  }
}
