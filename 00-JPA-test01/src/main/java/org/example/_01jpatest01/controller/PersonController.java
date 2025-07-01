package org.example._01jpatest01.controller;

import org.example._01jpatest01.repositories.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/people")
    public List<org.example._01jpatest01.domain.Person> getAllPeople() {
        return repository.findAll();
    }
}
