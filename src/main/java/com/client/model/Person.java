package com.client.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "location")
    private String location;
    @Column(name = "state")
    private String state;
    @Column(name = "income")
    private long income;

    @Column(name = "MaritalStatus")
    private String maritalStatus;

    public Person() {
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                ", State='" + state + '\'' +
                ", income=" + income +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }
}
