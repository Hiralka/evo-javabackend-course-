package com.hiraru.mavenproject1.repository;

import com.hiraru.mavenproject1.dto.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
