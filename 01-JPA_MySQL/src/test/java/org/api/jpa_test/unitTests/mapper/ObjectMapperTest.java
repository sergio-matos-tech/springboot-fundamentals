package org.api.jpa_test.unitTests.mapper;

import org.api.jpa_test.data.dto.PersonDTO;
import org.api.jpa_test.model.Person;
import org.api.jpa_test.unitTests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.api.jpa_test.mapper.ObjectMapper.parseListObjects;
import static org.api.jpa_test.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ObjectMapperTest {

    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTO output = parseObject(inputObject.mockEntity(0), PersonDTO.class);
        assertNotNull(output);
        assertEquals("John 0", output.getFirstName());
        assertEquals("Doe 0", output.getLastName());
        assertEquals("New York", output.getAddress().getCity());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTO> outputList = parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
        assertNotNull(outputList);

        PersonDTO outputZero = outputList.getFirst();
        assertNotNull(outputZero);
        assertEquals("John 0", outputZero.getFirstName());
        assertEquals("Doe 0", outputZero.getLastName());
        assertEquals("New York", outputZero.getAddress().getCity());
    }

    @Test
    public void parseDTOToEntityTest() {
        Person output = parseObject(inputObject.mockDTO(0), Person.class);
        assertNotNull(output);
        assertEquals("Mary 0", output.getFirstName());
        assertEquals("Williams 0", output.getLastName());
        assertEquals("Sydney", output.getAddress().getCity());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = parseListObjects(inputObject.mockDTOList(), Person.class);
        assertNotNull(outputList);

        Person outputZero = outputList.getFirst();
        assertNotNull(outputZero);
        assertEquals("Mary 0", outputZero.getFirstName());
        assertEquals("Williams 0", outputZero.getLastName());
        assertEquals("Sydney", outputZero.getAddress().getCity());
    }
}