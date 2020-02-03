package com.jpa.sample.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class CompositeKey implements Serializable {

	private int id;

	private LocalDate dateCreated;

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
	
	
}
