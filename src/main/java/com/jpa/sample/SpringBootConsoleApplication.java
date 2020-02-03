package com.jpa.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.sample.repo.EmployeeDao;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringBootConsoleApplication.class);

	@Autowired
	private EmployeeDao employeeDao;

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Started ");
		employeeDao.create();
	}
}