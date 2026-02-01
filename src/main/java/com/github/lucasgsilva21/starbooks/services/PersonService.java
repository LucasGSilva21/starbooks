package com.github.lucasgsilva21.starbooks.services;

import com.github.lucasgsilva21.starbooks.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Lucas");
        person.setLastName("Silva");
        person.setAddress("Divinópolis - Minas Gerais - Brasil");
        person.setGender("M");
        return person;
    }
}
