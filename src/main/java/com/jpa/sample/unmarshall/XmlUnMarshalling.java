package com.jpa.sample.unmarshall;

import com.jpa.sample.entity.EmployeeXml;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public final class XmlUnMarshalling {

  /**
   * This function will convert string object to POJO.
   *
   * @param xml Input String object
   * @return EmployeeXmlPOJO
   * @throws JAXBException If XML conversion failed.
   */
  public static EmployeeXml unMarshall(String xml) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeXml.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    StringReader reader = new StringReader(xml);
    return (EmployeeXml) unmarshaller.unmarshal(reader);
  }

  private XmlUnMarshalling(){

  }

}
