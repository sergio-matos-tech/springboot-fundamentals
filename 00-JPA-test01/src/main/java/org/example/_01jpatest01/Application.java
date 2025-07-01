package org.example._01jpatest01;

import org.example._01jpatest01.domain.Person;
import org.example._01jpatest01.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.IntStream;

@SpringBootApplication
@EntityScan("org.example._01jpatest01.domain")
@EnableJpaRepositories("org.example._01jpatest01.repositories")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            System.out.println("✅ Populando o banco de dados com 10 usuários...");

            // Limpa o banco de dados para garantir que começamos do zero a cada execução
            repository.deleteAll();

            // Cria e salva 10 pessoas
            IntStream.rangeClosed(1, 10).forEach(i -> {
                Person person = Person.builder()
                        .name("User " + i)
                        .email("user" + i + "@example.com")
                        .build();
                repository.save(person);
            });

            System.out.println("🎉 Banco de dados populado! Total de usuários: " + repository.count());
        };
    }
}