package org.api.jpa_test.service;

import org.api.jpa_test.data.dto.PersonDTO;
import org.api.jpa_test.mapper.ObjectMapper;
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

    public List<PersonDTO> findAll() {
        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(String id) {
        var entity = Optional.ofNullable(repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findFirstName(String firstName) {
        var entities = repository.findByFirstName(firstName);

        return ObjectMapper.parseListObjects(entities, PersonDTO.class);
    }

    public PersonDTO save(PersonDTO personToSave) {
        var entity = ObjectMapper.parseObject(personToSave, Person.class);

        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public void update(PersonDTO person) {
        var entity = ObjectMapper.parseObject(findById(person.getId()), Person.class);

        ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }

    public void deleteById(String id) {
        var entity = ObjectMapper.parseObject(findById(id), Person.class);

        ObjectMapper.parseObject(entity, PersonDTO.class);
    }
}