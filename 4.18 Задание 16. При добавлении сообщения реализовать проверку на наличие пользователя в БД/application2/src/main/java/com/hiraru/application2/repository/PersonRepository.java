package com.hiraru.application2.repository;

import com.hiraru.application2.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}