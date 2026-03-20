package com.deshdarshan.repository;

import com.deshdarshan.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    List<ContactMessage> findByStatus(String status);
    List<ContactMessage> findBySenderEmail(String email);
}
