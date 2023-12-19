package com.epam.TravelBooking.service.impl;

import com.epam.TravelBooking.model.RentalCar;
import com.epam.TravelBooking.repository.RentalCarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RentalCarServiceImplTest {

    @Mock
    private RentalCarRepository rentalCarRepository;

    @InjectMocks
    private RentalCarServiceImpl rentalCarService;

    public RentalCarServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRentalCars() {
        List<RentalCar> rentalCars = new ArrayList<>();
        when(rentalCarRepository.findAll()).thenReturn(rentalCars);

        List<RentalCar> result = rentalCarService.getAllRentalCars();

        assertEquals(rentalCars, result);
    }

    @Test
    void getRentalCarById() {
        long rentalCarId = 1L;
        RentalCar rentalCar = new RentalCar();
        rentalCar.setId(rentalCarId);
        when(rentalCarRepository.findById(rentalCarId)).thenReturn(Optional.of(rentalCar));

        RentalCar result = rentalCarService.getRentalCarById(rentalCarId);

        assertEquals(rentalCar, result);
    }

    @Test
    void saveRentalCar() {
        RentalCar rentalCar = new RentalCar();
        when(rentalCarRepository.save(any())).thenReturn(rentalCar);

        RentalCar result = rentalCarService.saveRentalCar(new RentalCar());

        assertEquals(rentalCar, result);
    }

    @Test
    void deleteRentalCar() {
        long rentalCarId = 1L;

        rentalCarService.deleteRentalCar(rentalCarId);

        verify(rentalCarRepository, times(1)).deleteById(rentalCarId);
    }

    @Test
    void searchRentalCars() {
        String brand = "Toyota";
        String model = "Camry";
        List<RentalCar> rentalCars = new ArrayList<>();
        when(rentalCarRepository.findByBrandAndModel(brand, model)).thenReturn(rentalCars);

        List<RentalCar> result = rentalCarService.searchRentalCars(brand, model);

        assertEquals(rentalCars, result);
    }
}
