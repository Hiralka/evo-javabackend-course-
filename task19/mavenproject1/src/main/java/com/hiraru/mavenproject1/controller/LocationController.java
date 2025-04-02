package com.hiraru.mavenproject1.controller;

import com.hiraru.mavenproject1.dto.Location;
import com.hiraru.mavenproject1.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @GetMapping("/{city}")
    public ResponseEntity<Location> getLocation(@PathVariable String city) {
        return locationRepository.findByCity(city)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}