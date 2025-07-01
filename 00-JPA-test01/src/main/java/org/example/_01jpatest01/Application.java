package org.example._01jpatest01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.example._01jpatest01.domain.Person;
import org.example._01jpatest01.repositories.PersonRepository;


@SpringBootApplication
@EntityScan("org.example._01jpatest01.domain")
@EnableJpaRepositories("org.example._01jpatest01.repositories")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            Person newUser = Person.builder()
                    .name("Jane Doe")
                    .email("jane.doe@example.com")
                    .build();
            repository.save(newUser);
            System.out.println("🎉 Successfully saved a new user!");
        };
    }
}