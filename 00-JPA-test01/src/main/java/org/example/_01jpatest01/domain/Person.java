package org.example._01jpatest01.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
@ToString
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    Integer id;

    String name;
    String email;

}

