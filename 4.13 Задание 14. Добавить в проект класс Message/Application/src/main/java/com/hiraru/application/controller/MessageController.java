package com.hiraru.application.controller;

import com.hiraru.application.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MessageController {
    private final List<Message> messages = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    // Получить все сообщения
    @GetMapping("/message")
    public List<Message> getAllMessages() {
        return messages;
    }

    // Получить сообщение по ID
    @GetMapping("/message/{id}")
    public Message getMessageById(@PathVariable int id) {
        return messages.stream()
                .filter(message -> message.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
    }

    // Создать новое сообщение
    @PostMapping("/message")
    public Message createMessage(@RequestBody Message message) {
        message.setId(idGenerator.getAndIncrement());
        messages.add(message);
        return message;
    }

    // Обновить сообщение
    @PutMapping("/message/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message updatedMessage) {
        Message existingMessage = getMessageById(id);
        existingMessage.setTitle(updatedMessage.getTitle());
        existingMessage.setText(updatedMessage.getText());
        existingMessage.setTime(updatedMessage.getTime());
        return existingMessage;
    }

    // Удалить сообщение
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        Message messageToDelete = getMessageById(id);
        messages.remove(messageToDelete);
    }
}