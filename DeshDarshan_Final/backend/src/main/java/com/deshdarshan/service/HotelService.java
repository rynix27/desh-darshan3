package com.deshdarshan.service;

import com.deshdarshan.model.Hotel;
import com.deshdarshan.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> getByCategory(String category) {
        return hotelRepository.findByCategoryIgnoreCase(category);
    }

    public List<Hotel> getByDestination(String destination) {
        return hotelRepository.findByDestinationNameIgnoreCase(destination);
    }

    public List<Hotel> getByMaxPrice(Integer maxPrice) {
        return hotelRepository.findByPricePerNightLessThanEqual(maxPrice);
    }

    public List<Hotel> getByMaxPriceAndCategory(Integer maxPrice, String category) {
        return hotelRepository.findByMaxPriceAndCategory(maxPrice, category);
    }

    public List<Hotel> getFeaturedHotels() {
        return hotelRepository.findByFeaturedTrue();
    }

    public List<Hotel> searchByName(String name) {
        return hotelRepository.findByNameContainingIgnoreCase(name);
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
