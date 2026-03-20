package com.deshdarshan.service;

import com.deshdarshan.model.Destination;
import com.deshdarshan.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Optional<Destination> getDestinationById(Long id) {
        return destinationRepository.findById(id);
    }

    public List<Destination> getByRegion(String region) {
        return destinationRepository.findByRegionIgnoreCase(region);
    }

    public List<Destination> searchByName(String name) {
        return destinationRepository.findByNameContainingIgnoreCase(name);
    }

    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
