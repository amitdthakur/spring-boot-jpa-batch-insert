package com.jpa.sample.unmarshall;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jpa.sample.dto.EmployeeXml;

public class XmlUnmarshalling {

	public EmployeeXml unmarshall() throws JAXBException {

		String xmlString = "<employee> <firstName>Lokesh</firstName>" + "    <id>1</id>"
				+ "  <lastName>34/03/2020</lastName>" + "</employee>";

		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeXml.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(xmlString);
		return (EmployeeXml) unmarshaller.unmarshal(reader);
	}

	public static void main(String[] args) throws JAXBException {
		EmployeeXml employee = new XmlUnmarshalling().unmarshall();
		System.out.println(employee.getLastName().getMonth());
	}
}
