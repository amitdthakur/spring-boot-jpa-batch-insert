package com.jpa.sample.config;

import com.jpa.sample.etl.DataBase;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class will create the beans for data base config.
 *
 * @author SAM
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

  /**
   * To inject data base configuration from yaml file.
   */
  private DataBase database;

  /**
   * Public constructor for auto wiring.
   *
   * @param database DataBase Object for data base configuration.
   */
  @Autowired
  public DatabaseConfig(DataBase database) {
    this.database = database;
  }

  /**
   * This function will create the {@link HikariDataSource} Object.
   *
   * @return {@link DataSource} Object.
   */
  @Bean
  public DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(database.getDriverName());
    dataSource.setJdbcUrl(database.getUrl());
    dataSource.setUsername(database.getUserName());
    dataSource.setPassword(database.getPassword());
    dataSource.setMaximumPoolSize(database.getMaximumPoolSize());
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
    additionalProperties.put("hibernate.show_sql", database.getShowSql());
    additionalProperties.put("hibernate.hbm2ddl.auto", database.getAutoDdl());
    additionalProperties.put("hibernate.jdbc.batch_size", database.getBatchSize());
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
   * PersistenceExceptionTranslationPostProcessor is a bean post processor which adds an advisor to
   * any bean annotated with Repository so that any platform-specific exceptions are caught and then
   * rethrown as one Spring's unchecked data access exceptions (i.e. a subclass of
   * DataAccessException).
   */
  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

}
