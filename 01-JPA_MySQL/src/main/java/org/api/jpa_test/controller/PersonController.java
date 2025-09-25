package org.api.jpa_test.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.jpa_test.model.Person;
import org.api.jpa_test.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public ResponseEntity<List<Person>> findByName(@RequestParam String firstName) {
        log.info("Searching people by first name: {}", firstName);

        var personFound = service.findFirstName(firstName);

        return ResponseEntity.ok(personFound);
    }

    @PostMapping
    public ResponseEntity<Optional<Person>> save(@RequestBody Person person) {
        log.info("saving a person");

        var personSaved = service.save(person);
        return ResponseEntity.ok(personSaved);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Person person) {
        log.info("Updating person");

        service.update(person);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        log.info("Deleting person with id: {}", id);

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}