package com.epam.TravelBooking.service;

import com.epam.TravelBooking.model.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<Flight> searchFlights(String origin, String destination, Date departureDate);
    List<Flight> getAllFlights();
    Flight getFlightById(Long id);
    Flight saveFlight(Flight flight);
    void deleteFlight(Long id);
}
