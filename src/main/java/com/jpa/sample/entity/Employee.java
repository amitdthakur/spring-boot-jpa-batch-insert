package com.jpa.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Employee entity mapped to employee table.
 *
 * @author sam
 */
@Entity
@Table(name = "employee")
@IdClass(CompositeKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SqlResultSetMapping(name = "resultSetMapping", entities = @EntityResult
    (entityClass = Employee.class), columns = @ColumnResult(name = "listSource"))
public class Employee {

  @Id
  private int id;

  @Id
  @Column(name = "date_created")
  private LocalDate dateCreated;

  @Column(name = "action_date")
  private LocalDateTime actionDate;

  @Transient
  private String listSource;

}
