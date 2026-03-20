package com.deshdarshan.controller;

import com.deshdarshan.model.Destination;
import com.deshdarshan.service.DestinationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = "*")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    // GET all destinations
    // URL: GET http://localhost:8080/api/destinations
    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }

    // GET single destination by ID
    // URL: GET http://localhost:8080/api/destinations/1
    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // GET destinations by region
    // URL: GET http://localhost:8080/api/destinations/region/north
    @GetMapping("/region/{region}")
    public ResponseEntity<List<Destination>> getByRegion(@PathVariable String region) {
        return ResponseEntity.ok(destinationService.getByRegion(region));
    }

    // GET search by name
    // URL: GET http://localhost:8080/api/destinations/search?name=Kerala
    @GetMapping("/search")
    public ResponseEntity<List<Destination>> searchDestinations(@RequestParam String name) {
        return ResponseEntity.ok(destinationService.searchByName(name));
    }

    // POST add new destination
    // URL: POST http://localhost:8080/api/destinations
    @PostMapping
    public ResponseEntity<Destination> addDestination(@Valid @RequestBody Destination destination) {
        Destination saved = destinationService.saveDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT update destination
    // URL: PUT http://localhost:8080/api/destinations/1
    @PutMapping("/{id}")
    public ResponseEntity<Destination> updateDestination(
            @PathVariable Long id,
            @Valid @RequestBody Destination destination) {
        return destinationService.getDestinationById(id)
            .map(existing -> {
                destination.setId(id);
                return ResponseEntity.ok(destinationService.saveDestination(destination));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE destination
    // URL: DELETE http://localhost:8080/api/destinations/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.ok("Destination deleted successfully");
    }
}
