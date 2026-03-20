package com.deshdarshan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hotel name is required")
    @Column(nullable = false)
    private String name;

    // budget / mid / luxury
    private String category;

    @NotNull(message = "Price is required")
    private Integer pricePerNight;

    private Double rating;

    @Column(columnDefinition = "TEXT")
    private String reviewQuote;

    private String destinationName;

    private Double latitude;

    private Double longitude;

    private String amenities;

    private Boolean featured;

    private String imageUrl;
}
