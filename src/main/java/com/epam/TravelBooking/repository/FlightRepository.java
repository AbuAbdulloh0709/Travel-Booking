package com.epam.TravelBooking.repository;

import com.epam.TravelBooking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAndDestinationAndDepartureDate(String origin, String destination, Date departureDate);
}
