package com.deshdarshan.controller;

import com.deshdarshan.model.Hotel;
import com.deshdarshan.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // GET all hotels
    // URL: GET http://localhost:8080/api/hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    // GET hotel by ID
    // URL: GET http://localhost:8080/api/hotels/1
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // GET hotels by category (budget / mid / luxury)
    // URL: GET http://localhost:8080/api/hotels/category/luxury
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Hotel>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(hotelService.getByCategory(category));
    }

    // GET hotels by destination
    // URL: GET http://localhost:8080/api/hotels/destination/Kerala
    @GetMapping("/destination/{destination}")
    public ResponseEntity<List<Hotel>> getByDestination(@PathVariable String destination) {
        return ResponseEntity.ok(hotelService.getByDestination(destination));
    }

    // GET hotels by max price
    // URL: GET http://localhost:8080/api/hotels/filter?maxPrice=5000&category=all
    @GetMapping("/filter")
    public ResponseEntity<List<Hotel>> filterHotels(
            @RequestParam(defaultValue = "99999") Integer maxPrice,
            @RequestParam(defaultValue = "all") String category) {
        return ResponseEntity.ok(hotelService.getByMaxPriceAndCategory(maxPrice, category));
    }

    // GET featured hotels
    // URL: GET http://localhost:8080/api/hotels/featured
    @GetMapping("/featured")
    public ResponseEntity<List<Hotel>> getFeaturedHotels() {
        return ResponseEntity.ok(hotelService.getFeaturedHotels());
    }

    // GET search hotels by name
    // URL: GET http://localhost:8080/api/hotels/search?name=Taj
    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestParam String name) {
        return ResponseEntity.ok(hotelService.searchByName(name));
    }

    // POST add new hotel
    // URL: POST http://localhost:8080/api/hotels
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
    }

    // PUT update hotel
    // URL: PUT http://localhost:8080/api/hotels/1
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable Long id,
            @Valid @RequestBody Hotel hotel) {
        return hotelService.getHotelById(id)
            .map(existing -> {
                hotel.setId(id);
                return ResponseEntity.ok(hotelService.saveHotel(hotel));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE hotel
    // URL: DELETE http://localhost:8080/api/hotels/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Hotel deleted successfully");
    }
}
