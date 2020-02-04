package com.jpa.sample.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Employee entity mapped to employee table.
 * 
 * @author sam
 *
 */
@Entity
@Table(name = "employee")
@IdClass(CompositeKey.class)
public class Employee {

	@Id
	private int id;

	@Id
	@Column(name = "date_created")
	private LocalDate dateCreated;

	public Employee(int id, LocalDate dateCreated) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Employee() {
		super();
	}

}
