package org.api.jpa_test.data.dto;


import lombok.*;
import org.api.jpa_test.support.Address;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String id;

    private String firstName;
    private String lastName;

    private Address address;


}
