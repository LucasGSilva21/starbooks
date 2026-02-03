package com.github.lucasgsilva21.starbooks.services;

import com.github.lucasgsilva21.starbooks.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all person!");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            persons.add(this.mockPerson());
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one person!");
        return this.mockPerson();
    }

    public Person create(Person person) {
        logger.info("Creating person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }

    private Person mockPerson() {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Lucas");
        person.setLastName("Silva");
        person.setAddress("Divinópolis - Minas Gerais - Brasil");
        person.setGender("M");
        return person;
    }
}
