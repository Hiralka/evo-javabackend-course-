package com.hiraru.application2.controller;

import com.hiraru.application2.dto.Message;
import com.hiraru.application2.dto.Person;
import com.hiraru.application2.repository.MessageRepository;
import com.hiraru.application2.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;

    public PersonController(PersonRepository personRepository, 
                          MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }
    
    //GET /person
    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    //GET /person/{id}
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    
    //POST /person
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
    
    //PUT /person/{id}
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setFirstname(updatedPerson.getFirstname());
                    person.setSurname(updatedPerson.getSurname());
                    person.setLastname(updatedPerson.getLastname());
                    person.setBirthday(updatedPerson.getBirthday());
                    return personRepository.save(person);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    //DELETE /person/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }

    //POST /person/{p_id}/message
    @PostMapping("/{p_id}/message")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addMessage(@PathVariable("p_id") int personId, @RequestBody Message message) {
        if (!personRepository.existsById(personId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        message.setTime(LocalDateTime.now());
        person.addMessage(message);
        return personRepository.save(person);
    }
    
    //GET /person/{p_id}/message
    @GetMapping("/{p_id}/message")
    public List<Message> getPersonMessages(@PathVariable("p_id") int personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        return person.getMessages();
    }
    
    //GET /person/{p_id}/message/{m_id}
    @GetMapping("/{p_id}/message/{m_id}")
    public Message getPersonMessage(@PathVariable("p_id") int personId,
                                  @PathVariable("m_id") int messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        if (message.getPerson().getId() != personId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        return message;
    }
    
    //DELETE /person/{p_id}/message/{m_id}
    @DeleteMapping("/{p_id}/message/{m_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonMessage(@PathVariable("p_id") int personId,
                                   @PathVariable("m_id") int messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        if (message.getPerson().getId() != personId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        messageRepository.delete(message);
    }
}