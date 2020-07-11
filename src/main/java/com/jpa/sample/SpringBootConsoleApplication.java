package com.jpa.sample;

import com.jpa.sample.entity.Employee;
import com.jpa.sample.service.EmployeeService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for application.
 *
 * @author SAM
 */
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

  /**
   * Logger instance
   */
  private Logger logger = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
  /**
   * Employee service object.
   */
  private EmployeeService employeeService;

  /**
   * Public constructor for auto wiring.
   *
   * @param employeeService EmployeeService object.
   */
  @Autowired
  public SpringBootConsoleApplication(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  /**
   * Entry point for the application
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
  }

  @Override
  public void run(String... args) {
    logger.info(".....Application started.....");
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee(1, LocalDate.now(), LocalDateTime.now(), null));
    employeeService.createEmployees(employeeList);
    //Select statement on the data base
    //logger.info("Select result {} ", employeeService.selectEmployees());
  }
}
