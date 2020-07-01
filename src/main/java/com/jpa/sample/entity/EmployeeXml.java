package com.jpa.sample.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "employee")
@Data
public class EmployeeXml {

  private Integer id;

  private String firstName;

  private LocalDate birthDate;
}
