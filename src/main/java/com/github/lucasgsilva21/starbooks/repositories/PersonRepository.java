package com.github.lucasgsilva21.starbooks.repositories;

import com.github.lucasgsilva21.starbooks.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
