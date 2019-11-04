package com.client.service;

import com.client.model.Person;

import java.util.List;

public interface PersonInfoI {
    public Person createPersonInfo(Person person);
    public List<Person> getPersonInfo(String type, String value);
}
