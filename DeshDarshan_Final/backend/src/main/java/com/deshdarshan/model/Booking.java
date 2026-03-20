package com.deshdarshan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Guest name is required")
    private String guestName;

    @Email(message = "Valid email is required")
    @NotBlank(message = "Email is required")
    private String email;

    // hotel / festival / show / dance
    private String bookingType;

    private String itemName;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Integer numberOfGuests;

    private Integer totalAmount;

    // PENDING / CONFIRMED / CANCELLED
    private String status;

    private String specialRequests;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) this.status = "PENDING";
    }
}
