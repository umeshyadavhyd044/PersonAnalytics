package com.client.controller;

import com.client.model.Person;
import com.client.service.PersonInfoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    @Autowired(required = true)
    private PersonInfoI personInfo;

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {

        Person personRecord = personInfo.createPersonInfo(person);
        return new ResponseEntity<Person>(personRecord, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getPerson")
    public ResponseEntity<List<Person>> getPerson(@RequestParam String type, @RequestParam String value) {
        List<Person> personList = personInfo.getPersonInfo(type, value);
        return new ResponseEntity<List<Person>>(personList, new HttpHeaders(), HttpStatus.OK);
    }


}
