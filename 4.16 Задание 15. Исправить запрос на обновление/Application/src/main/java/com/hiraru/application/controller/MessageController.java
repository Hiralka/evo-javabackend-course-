package com.hiraru.application.controller;

import com.hiraru.application.dto.Message;
import com.hiraru.application.repository.MessageRepository;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    // GET /message
    @GetMapping
    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    // GET /message/{id}
    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
    }

    // POST /message
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message createMessage(@RequestBody Message message) {
        message.setTime(LocalDateTime.now()); // Автоматически ставим текущее время
        return repository.save(message);
    }

    // PUT /message/{id}
    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message updatedMessage) {
        return repository.findById(id)
                .map(message -> {
                    message.setTitle(updatedMessage.getTitle());
                    message.setText(updatedMessage.getText());
                    message.setTime(updatedMessage.getTime());
                    return repository.save(message);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
    }

    // DELETE /message/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable int id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
        }
        repository.deleteById(id);
    }
}

