package com.deshdarshan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String senderName;

    @Email(message = "Valid email required")
    @NotBlank(message = "Email is required")
    private String senderEmail;

    private String subject;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Message is required")
    private String message;

    // NEW / READ / REPLIED
    private String status;

    @Column(updatable = false)
    private LocalDateTime sentAt;

    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
        if (this.status == null) this.status = "NEW";
    }
}
