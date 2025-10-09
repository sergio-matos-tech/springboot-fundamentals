package org.api.jpa_test.unitTests.mapper.mocks;

import org.api.jpa_test.data.dto.PersonDTO;
import org.api.jpa_test.model.Person;
import org.api.jpa_test.support.Address;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }

    // In MockPerson.java

    public Person mockEntity(Integer number) {
        return Person.builder()
                .firstName("John " + number)
                .lastName("Doe " + number)
                .email("john" + number + "@gmail.com")
                .address(new Address("New York", "NY", "USA", "10001"))
                .build();
    }

    public PersonDTO mockDTO(Integer number) {
        return PersonDTO.builder()
                .firstName("Mary " + number)
                .lastName("Williams " + number)
                .address(new Address("Sydney", "NSW", "Australia", "2000"))
                .build();
    }

}
