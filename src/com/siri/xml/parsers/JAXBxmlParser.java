package com.siri.xml.parsers;

import javax.xml.bind.*;
import java.io.File;

public class JAXBxmlParser {
    public static void main(String[] args) throws JAXBException {
        //AXB (Java Architecture for XML Binding) is a specific API (the stuff under javax.xml.bind)
        // that uses annotations to bind XML documents to a java object model.

        //convert java to xml and xml to java using JAXB (java architecture for XML Binding API)
        //Java Object to XML- Marshalling
        //XML to Java Object -UnMarshalling
        //required in webservices (SOAP- to communicate with services)

        //step1: create binding class (Java Bean/POJO)
        //created Employee POJO

        //step2: define the mapping between java elements to XML (using JAXB annotation)
        //required to tell the DOM structure(Root Element and child Element and order details) using JAXB mapping
        //for both Marshalling and Unmarshalling
        //in POJO see annotations @XMLRootElement


        //step3: write the logic for marshalling/unmarshalling
        //a. Marshalling JavaObject (Employee.java) to XML(Employee.xml)
        Employee employee = new Employee();
        employee.setName("Acha");
        employee.setSex("Female");
        employee.setDepartment("CS");
        employee.setAge(24);

        //create JAXBContext for  converting .java to .xml
        JAXBContext jaxbContext = JAXBContext.newInstance(employee.getClass());


        //create marshaller from JAXBContext
        Marshaller marshaller = jaxbContext.createMarshaller();

        //call marshall method from marshaller
        marshaller.marshal(employee,System.out);


        //b.Unmarshalling XML to Java Object
        File file=new File("sample.xml");


        //create unmarshaller from JAXBContext
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //call unmarshall method from marshaller
        Object javaObject = unmarshaller.unmarshal(file);
        Employee downCasted=(Employee) javaObject;

    }
}

