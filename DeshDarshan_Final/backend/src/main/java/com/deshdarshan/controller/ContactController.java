package com.deshdarshan.controller;

import com.deshdarshan.model.ContactMessage;
import com.deshdarshan.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactMessageService contactMessageService;

    // POST send a contact message
    // URL: POST http://localhost:8080/api/contact
    @PostMapping
    public ResponseEntity<ContactMessage> sendMessage(
            @Valid @RequestBody ContactMessage message) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(contactMessageService.saveMessage(message));
    }

    // GET all messages (admin)
    // URL: GET http://localhost:8080/api/contact
    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllMessages() {
        return ResponseEntity.ok(contactMessageService.getAllMessages());
    }

    // GET only new unread messages
    // URL: GET http://localhost:8080/api/contact/new
    @GetMapping("/new")
    public ResponseEntity<List<ContactMessage>> getNewMessages() {
        return ResponseEntity.ok(contactMessageService.getNewMessages());
    }

    // PUT mark message as read
    // URL: PUT http://localhost:8080/api/contact/1/read
    @PutMapping("/{id}/read")
    public ResponseEntity<ContactMessage> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(contactMessageService.markAsRead(id));
    }
}
