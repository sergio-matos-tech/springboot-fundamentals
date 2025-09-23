package org.api.jpa_test.model;

import jakarta.persistence.*;
import lombok.*;
import org.api.jpa_test.support.Address;

import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Person {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String firstName;
    private String lastName;

    @Embedded
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}