package org.api.jpa_test.repositories;

import org.api.jpa_test.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {

    List<Person> findByFirstName(String firstName);
}
