package com.jpa.sample.entity;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.jpa.sample.unmarshall.DateFormatAdapter;

@XmlRootElement(name = "employee")
public class EmployeeXml {
	private Integer id;
	private String firstName;
	private LocalDate birthDate;

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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	@XmlJavaTypeAdapter(DateFormatAdapter.class)
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "EmployeeXml [id=" + id + ", firstName=" + firstName + ", birthDate=" + birthDate + "]";
	}

}
