package com.jpa.sample;

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

import com.jpa.sample.entity.Employee;
import com.jpa.sample.repo.EmployeeDao;
import com.jpa.sample.repo.EmployeeRepository;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	/**
	 * Logger instance
	 */
	private Logger logger = LoggerFactory.getLogger(SpringBootConsoleApplication.class);

	private EmployeeDao employeeDao;

	private EmployeeRepository employeeRepository;

	@Autowired
	public SpringBootConsoleApplication(EmployeeDao employeeDao, EmployeeRepository employeeRepository) {
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
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, LocalDate.now(), LocalDateTime.now()));
		employeeDao.createEmployees(employeeList);

	}
}