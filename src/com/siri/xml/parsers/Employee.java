package com.siri.xml.parsers;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name="Employee")
public class Employee implements Serializable {
    // @XmlAttribute(name="name")required to specify name of the child element in xml and the order
    @XmlAttribute(name="name")
    private String name;

    @XmlAttribute(name="age")
    private int age;

    @XmlAttribute(name="sex")
    private String sex;

    @XmlAttribute(name="department")
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
