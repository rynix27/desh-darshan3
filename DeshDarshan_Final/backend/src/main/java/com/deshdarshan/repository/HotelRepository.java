package com.deshdarshan.repository;

import com.deshdarshan.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByCategoryIgnoreCase(String category);

    List<Hotel> findByDestinationNameIgnoreCase(String destinationName);

    List<Hotel> findByPricePerNightLessThanEqual(Integer maxPrice);

    @Query("SELECT h FROM Hotel h WHERE h.pricePerNight <= :maxPrice AND (:category = 'all' OR LOWER(h.category) = LOWER(:category))")
    List<Hotel> findByMaxPriceAndCategory(Integer maxPrice, String category);

    List<Hotel> findByFeaturedTrue();

    List<Hotel> findByNameContainingIgnoreCase(String name);
}
