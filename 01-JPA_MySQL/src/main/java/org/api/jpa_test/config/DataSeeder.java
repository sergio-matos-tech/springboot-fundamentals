package org.api.jpa_test.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.jpa_test.model.Person;
import org.api.jpa_test.repositories.PersonRepository;
import org.api.jpa_test.support.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataSeeder implements CommandLineRunner {

    private static final Logger log = LogManager.getLogger(DataSeeder.class);
    private final PersonRepository repository;

    public DataSeeder(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            log.info("Seeding database with initial data.");
            List<Person> people = Arrays.asList(
                    Person.builder()
                            .firstName("John")
                            .lastName("Doe")
                            .email("john@gmail.com")
                            .address(new Address("New York", "NY", "USA", "10001"))
                            .build(),
                    Person.builder()
                            .firstName("Jane")
                            .lastName("Smith")
                            .email("jane@hotmail.com")
                            .address(new Address("Los Angeles", "CA", "USA", "90210"))
                            .build(),
                    Person.builder()
                            .firstName("Peter")
                            .lastName("Jones")
                            .email("peter@yahoo.com")
                            .address(new Address("London", "N1", "UK", "12345"))
                            .build(),
                    Person.builder()
                            .firstName("Mary")
                            .lastName("Williams")
                            .email("mary@example.com")
                            .address(new Address("Sydney", "NSW", "Australia", "2000"))
                            .build(),
                    Person.builder()
                            .firstName("Michael")
                            .lastName("Brown")
                            .address(new Address("Toronto", "ON", "Canada", "M5A 1A1"))
                            .build()
            );

            repository.saveAll(people);
            log.info("Database seeding completed. {} people inserted.", repository.count());
        } else {
            log.info("Database is already populated. Skipping seeding.");
        }
    }
}