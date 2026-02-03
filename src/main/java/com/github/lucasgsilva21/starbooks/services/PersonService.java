package com.github.lucasgsilva21.starbooks.services;

import com.github.lucasgsilva21.starbooks.model.Person;
import com.github.lucasgsilva21.starbooks.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final Logger logger =
            Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        logger.info("Finding all persons");
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person");

        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public Person create(Person person) {
        logger.info("Creating person");
        return personRepository.save(person);
    }

    public Person update(Long id, Person person) {
        logger.info("Updating person");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        personRepository.delete(entity);
    }
}
