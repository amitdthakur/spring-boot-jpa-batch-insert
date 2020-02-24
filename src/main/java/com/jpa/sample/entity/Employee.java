package com.jpa.sample.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee entity mapped to employee table.
 * 
 * @author sam
 *
 */
@Entity
@Table(name = "employee")
@IdClass(CompositeKey.class)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {

	@Id
	private int id;

	@Id
	@Column(name = "date_created")
	private LocalDate dateCreated;
	
	@Column(name = "action_date")
	private LocalDateTime actionDate;


	
}
