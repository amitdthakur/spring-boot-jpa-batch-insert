package com.jpa.sample.etl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Data base configuration class to map values from external file.
 *
 * @author SAM
 */
@Configuration
@ConfigurationProperties(prefix = "database")
@Data
public class DataBase {

  private String url;
  private String userName;
  private String password;
  private String driverName;
  private int maximumPoolSize;
  private String showSql;
  private String autoDdl;
  private String batchSize;
}
