package com.hiraru.mavenproject1.repository;

import com.hiraru.mavenproject1.dto.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
    Optional<Location> findByCity(String city);
}