package com.jpa.sample.unmarshall;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateFormatAdapter extends XmlAdapter<String, LocalDate> {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Marshal converting Java to XML
	@Override
	public String marshal(LocalDate date) throws Exception {
		return date.toString();
	}

	// UnMarshal converting XML to Java
	@Override
	public LocalDate unmarshal(String date) throws Exception {
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}

}
