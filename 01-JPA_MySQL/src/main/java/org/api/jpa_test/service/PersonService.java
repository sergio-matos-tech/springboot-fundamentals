package org.api.jpa_test.service;

import org.api.jpa_test.model.Person;
import org.api.jpa_test.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findById(String id) {
        return Optional.ofNullable(repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public Optional<Person> save(Person person) {
        var personSaved = repository.save(person);
        return Optional.of(personSaved);
    }

    public void update(Person person) {
        findById(person.getId());

        repository.save(person);
    }

    public void deleteById(String id) {
        var personToDelete = findById(id);
        repository.deleteById(id);
    }
}