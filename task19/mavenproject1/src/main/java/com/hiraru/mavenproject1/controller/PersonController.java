package com.hiraru.mavenproject1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.hiraru.mavenproject1.dto.Location;
import com.hiraru.mavenproject1.dto.Person;
import com.hiraru.mavenproject1.dto.Weather;
import com.hiraru.mavenproject1.repository.LocationRepository;
import com.hiraru.mavenproject1.repository.PersonRepository;
import com.hiraru.mavenproject1.repository.WeatherRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private WeatherRepository weatherRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    @GetMapping("/{id}/weather")
    public ResponseEntity<Map<String, Object>> getPersonWeather(@PathVariable int id) {
        Optional<Person> personOpt = personRepository.findById(id);
        if (personOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Person person = personOpt.get();

        String city = person.getLocation();
        Optional<Location> locationOpt = locationRepository.findByCity(city);
        if (locationOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Location location = locationOpt.get();
        double lat = location.getLatitude();
        double lon = location.getLongitude();

        Optional<Weather> weatherOpt = weatherRepository.findByLatitudeAndLongitude(lat, lon);

        if (weatherOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("personName", person.getName());
        response.put("location", person.getLocation());
        response.put("weather", weatherOpt.get());

        return ResponseEntity.ok(response);
    }
}