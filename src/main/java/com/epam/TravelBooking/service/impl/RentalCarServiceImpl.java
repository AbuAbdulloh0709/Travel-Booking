package com.epam.TravelBooking.service.impl;

import com.epam.TravelBooking.model.RentalCar;
import com.epam.TravelBooking.repository.RentalCarRepository;
import com.epam.TravelBooking.service.RentalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalCarServiceImpl implements RentalCarService {

    private final RentalCarRepository rentalCarRepository;

    @Autowired
    public RentalCarServiceImpl(RentalCarRepository rentalCarRepository) {
        this.rentalCarRepository = rentalCarRepository;
    }

    @Override
    public List<RentalCar> getAllRentalCars() {
        return rentalCarRepository.findAll();
    }

    @Override
    public RentalCar getRentalCarById(Long id) {
        return rentalCarRepository.findById(id).orElse(null);
    }

    @Override
    public RentalCar saveRentalCar(RentalCar rentalCar) {
        return rentalCarRepository.save(rentalCar);
    }

    @Override
    public void deleteRentalCar(Long id) {
        rentalCarRepository.deleteById(id);
    }

    @Override
    public List<RentalCar> searchRentalCars(String brand, String model) {
        return rentalCarRepository.findByBrandAndModel(brand, model);
    }
}

