package org.api.jpa_test.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.jpa_test.model.Person;
import org.api.jpa_test.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    private static final Logger log = LogManager.getLogger(PersonController.class);
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        log.info("findAll controller");
        var peopleFound = service.findAll();
        return ResponseEntity.ok(peopleFound);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable String id) {
        log.info("findById Controller");

        var personFound = service.findById(id);
        return ResponseEntity.ok(personFound);
    }
}