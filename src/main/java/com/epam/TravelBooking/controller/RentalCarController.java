package com.epam.TravelBooking.controller;

import com.epam.TravelBooking.model.RentalCar;
import com.epam.TravelBooking.service.RentalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-cars")
public class RentalCarController {

    private final RentalCarService rentalCarService;

    @Autowired
    public RentalCarController(RentalCarService rentalCarService) {
        this.rentalCarService = rentalCarService;
    }

    @GetMapping
    public List<RentalCar> getAllRentalCars() {
        return rentalCarService.getAllRentalCars();
    }

    @GetMapping("/{id}")
    public RentalCar getRentalCarById(@PathVariable Long id) {
        return rentalCarService.getRentalCarById(id);
    }

    @PostMapping
    public RentalCar saveRentalCar(@RequestBody RentalCar rentalCar) {
        return rentalCarService.saveRentalCar(rentalCar);
    }

    @PutMapping("/{id}")
    public RentalCar updateRentalCar(@PathVariable Long id, @RequestBody RentalCar rentalCar) {
        rentalCar.setId(id);
        return rentalCarService.saveRentalCar(rentalCar);
    }

    @DeleteMapping("/{id}")
    public void deleteRentalCar(@PathVariable Long id) {
        rentalCarService.deleteRentalCar(id);
    }
}

