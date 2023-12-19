package com.epam.TravelBooking.repository;

import com.epam.TravelBooking.model.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {
    List<RentalCar> findByBrandAndModel(String brand, String model);
}
