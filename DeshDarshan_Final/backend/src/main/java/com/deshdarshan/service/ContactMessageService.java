package com.deshdarshan.service;

import com.deshdarshan.model.ContactMessage;
import com.deshdarshan.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessage saveMessage(ContactMessage message) {
        return contactMessageRepository.save(message);
    }

    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    public List<ContactMessage> getNewMessages() {
        return contactMessageRepository.findByStatus("NEW");
    }

    public ContactMessage markAsRead(Long id) {
        ContactMessage msg = contactMessageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Message not found"));
        msg.setStatus("READ");
        return contactMessageRepository.save(msg);
    }
}
