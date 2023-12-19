package com.epam.TravelBooking.service;

import com.epam.TravelBooking.model.RentalCar;

import java.util.List;

public interface RentalCarService {
    List<RentalCar> getAllRentalCars();
    RentalCar getRentalCarById(Long id);
    RentalCar saveRentalCar(RentalCar rentalCar);
    void deleteRentalCar(Long id);

    List<RentalCar> searchRentalCars(String brand, String model);
}

