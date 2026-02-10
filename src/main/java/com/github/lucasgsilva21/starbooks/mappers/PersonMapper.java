package com.github.lucasgsilva21.starbooks.mappers;

import com.github.lucasgsilva21.starbooks.dtos.PersonDTO;
import com.github.lucasgsilva21.starbooks.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDto(Person entity);

    @Mapping(target = "id", ignore = true)
    Person toEntity(PersonDTO dto);
}
