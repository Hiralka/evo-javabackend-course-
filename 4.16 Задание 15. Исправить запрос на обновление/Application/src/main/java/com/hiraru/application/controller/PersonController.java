package com.hiraru.application.controller;


import com.hiraru.application.dto.Person;
import com.hiraru.application.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    // GET /person
    @GetMapping
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    // GET /person/{id}
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
    }

    // POST /person
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    // PUT /person/{id}
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person updatedPerson) {
        return repository.findById(id)
                .map(person -> {
                    person.setFirstname(updatedPerson.getFirstname());
                    person.setSurname(updatedPerson.getSurname());
                    person.setLastname(updatedPerson.getLastname());
                    person.setBirthday(updatedPerson.getBirthday());
                    return repository.save(person);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
    }

    // DELETE /person/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable int id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
        repository.deleteById(id);
    }
}