package com.deshdarshan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "destinations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "State is required")
    private String state;

    private String region;

    private String capital;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String tagline;

    private String bestTime;

    private String budget;

    private Double latitude;

    private Double longitude;

    private String imageUrl;
}
