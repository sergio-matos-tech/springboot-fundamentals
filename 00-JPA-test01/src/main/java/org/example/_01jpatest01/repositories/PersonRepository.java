package org.example._01jpatest01.repositories;

import org.example._01jpatest01.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
