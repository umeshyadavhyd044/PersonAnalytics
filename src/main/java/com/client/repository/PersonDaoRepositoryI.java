package com.client.repository;

import com.client.model.Person;

import java.util.List;

public interface PersonDaoRepositoryI {
    List<Person> findPersonByTypeAndValue(String type, String value);
}
