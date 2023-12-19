package com.epam.TravelBooking.service.impl;

import com.epam.TravelBooking.model.Flight;
import com.epam.TravelBooking.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    public FlightServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchFlights() {
        String origin = "CityA";
        String destination = "CityB";
        Date departureDate = new Date();
        List<Flight> flights = new ArrayList<>();
        when(flightRepository.findByOriginAndDestinationAndDepartureDate(origin, destination, departureDate)).thenReturn(flights);

        List<Flight> result = flightService.searchFlights(origin, destination, departureDate);

        assertEquals(flights, result);
    }

    @Test
    void getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        when(flightRepository.findAll()).thenReturn(flights);

        List<Flight> result = flightService.getAllFlights();

        assertEquals(flights, result);
    }

    @Test
    void getFlightById() {
        long flightId = 1L;
        Flight flight = new Flight();
        flight.setId(flightId);
        when(flightRepository.findById(flightId)).thenReturn(Optional.of(flight));

        Flight result = flightService.getFlightById(flightId);

        assertEquals(flight, result);
    }

    @Test
    void saveFlight() {
        Flight flight = new Flight();
        when(flightRepository.save(any())).thenReturn(flight);

        Flight result = flightService.saveFlight(new Flight());

        assertEquals(flight, result);
    }

    @Test
    void deleteFlight() {
        long flightId = 1L;

        flightService.deleteFlight(flightId);

        verify(flightRepository, times(1)).deleteById(flightId);
    }
}

