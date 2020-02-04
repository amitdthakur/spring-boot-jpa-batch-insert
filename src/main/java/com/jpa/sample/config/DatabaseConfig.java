package com.jpa.sample.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * This class will create the beans for data base config.
 * 
 * @author sam
 *
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	/**
	 * This function will create the {@link HikariDataSource} Object.
	 * 
	 * @return {@link DataSource} Object.
	 */
	// TODO:Please replace the below properties as per the data base server.
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setJdbcUrl("");
		dataSource.setUsername("");
		dataSource.setPassword("");
		dataSource.setMaximumPoolSize(10);
		return dataSource;
	}

	/**
	 * Declare the JPA entity manager factory.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		// Classpath scanning of @Component, @Service, etc annotated class
		entityManagerFactory.setPackagesToScan("com.jpa");
		// Vendor adapter
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.show_sql", "true");
		additionalProperties.put("hibernate.hbm2ddl.auto", "none");
		additionalProperties.put("hibernate.jdbc.batch_size", "5");
		additionalProperties.put("hibernate.order_inserts", "true");
		additionalProperties.put("hibernate.order_updates", "true");
		additionalProperties.put("hibernate.jdbc.batch_versioned_data", "true");
		entityManagerFactory.setJpaProperties(additionalProperties);
		return entityManagerFactory;
	}

	/**
	 * Declare the transaction manager.
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	/**
	 * PersistenceExceptionTranslationPostProcessor is a bean post processor which
	 * adds an advisor to any bean annotated with Repository so that any
	 * platform-specific exceptions are caught and then rethrown as one Spring's
	 * unchecked data access exceptions (i.e. a subclass of DataAccessException).
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
