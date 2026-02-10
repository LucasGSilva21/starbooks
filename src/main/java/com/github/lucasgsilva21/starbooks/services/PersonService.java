package com.github.lucasgsilva21.starbooks.services;

import com.github.lucasgsilva21.starbooks.dtos.PersonDTO;
import com.github.lucasgsilva21.starbooks.mappers.PersonMapper;
import com.github.lucasgsilva21.starbooks.models.Person;
import com.github.lucasgsilva21.starbooks.repositories.PersonRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final Logger logger =
            Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper mapper) {
        this.personRepository = personRepository;
        this.personMapper = mapper;
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all persons");
        return personRepository.findAll()
                .stream()
                .map(personMapper::toDto)
                .toList();
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one person");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        return personMapper.toDto(entity);
    }

    @Transactional
    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating person");
        Person entity = personMapper.toEntity(personDTO);
        Person saved = personRepository.save(entity);
        return personMapper.toDto(saved);
    }

    @Transactional
    public PersonDTO update(Long id, PersonDTO personDTO) {
        logger.info("Updating person");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());

        Person updated = personRepository.save(entity);
        return personMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        logger.info("Deleting one person");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        personRepository.delete(entity);
    }
}
