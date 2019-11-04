package com.client.service.impl;

import com.client.model.Person;
import com.client.repository.PersonDaoRepositoryI;
import com.client.repository.PersonRepository;
import com.client.service.PersonInfoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonInfoImpl implements PersonInfoI {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDaoRepositoryI personRepositoryCustom;

    public Person createPersonInfo(Person entity) {
        Optional<Person> person = personRepository.findById(entity.getId());
        if (person.isPresent()) {
            Person personDetails = person.get();
            personDetails.setAge(entity.getAge());
            personDetails.setGender(entity.getGender());
            personDetails.setIncome(entity.getIncome());
            personDetails.setLocation(entity.getLocation());
            personDetails.setName(entity.getName());
            personDetails.setState(entity.getState());
            personDetails = personRepository.save(personDetails);
            return personDetails;
        } else {
            entity = personRepository.save(entity);
            System.out.println(entity);
            return entity;
        }
    }

    public List<Person> getPersonInfo(String type, String value) {
        return personRepositoryCustom.findPersonByTypeAndValue(type, value);
    }


}


