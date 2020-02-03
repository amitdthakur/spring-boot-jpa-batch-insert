package com.jpa.sample.dto;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.jpa.sample.unmarshall.DateFormatAdapter;

@XmlRootElement(name = "employee")
public class EmployeeXml {
	private Integer id;
	private String firstName;
	private LocalDate lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getLastName() {
		return lastName;
	}

	@XmlJavaTypeAdapter(DateFormatAdapter.class)
	public void setLastName(LocalDate lastName) {
		this.lastName = lastName;
	}

	public EmployeeXml() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeXml [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
