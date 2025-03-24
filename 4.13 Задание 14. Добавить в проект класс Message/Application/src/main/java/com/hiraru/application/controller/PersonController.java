package com.hiraru.application.controller;

import com.hiraru.application.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class PersonController {
    private final List<Person> persons = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    // Получить человеков
    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return persons;
    }
    
    // Получить человеков по ID
    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable int id) {
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
    }

    // Создать нового человека
    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        person.setId(idGenerator.getAndIncrement());
        persons.add(person);
        return person;
    }

    // Обновить данные человека
    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person updatedPerson) {
        Person existingPerson = getPersonById(id);
        existingPerson.setFirstname(updatedPerson.getFirstname());
        existingPerson.setSurname(updatedPerson.getSurname());
        existingPerson.setLastname(updatedPerson.getLastname());
        existingPerson.setBirthday(updatedPerson.getBirthday());
        return existingPerson;
    }

    // Удалить человека
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        Person personToDelete = getPersonById(id);
        persons.remove(personToDelete);
    }
}