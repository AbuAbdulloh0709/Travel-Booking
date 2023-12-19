package com.epam.TravelBooking.controller;

import com.epam.TravelBooking.expedia.ExpediaFlightResponse;
import com.epam.TravelBooking.expedia.ExpediaHotelResponse;
import com.epam.TravelBooking.expedia.ExpediaRentalCarResponse;
import com.epam.TravelBooking.service.ExpediaIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/expedia")
public class ExpediaIntegrationController {

    private final ExpediaIntegrationService expediaIntegrationService;

    @Autowired
    public ExpediaIntegrationController(ExpediaIntegrationService expediaIntegrationService) {
        this.expediaIntegrationService = expediaIntegrationService;
    }

    @GetMapping("/flights")
    public List<ExpediaFlightResponse> getFlightAvailability(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate) {
        return expediaIntegrationService.getFlightAvailability(origin, destination, departureDate);
    }

    @GetMapping("/hotels")
    public List<ExpediaHotelResponse> getHotelAvailability(
            @RequestParam String location,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkInDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkOutDate) {
        return expediaIntegrationService.getHotelAvailability(location, checkInDate, checkOutDate);
    }

    @GetMapping("/rental-cars")
    public List<ExpediaRentalCarResponse> getRentalCarAvailability(
            @RequestParam String city,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date pickupDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date returnDate) {
        return expediaIntegrationService.getRentalCarAvailability(city, pickupDate, returnDate);
    }
}

