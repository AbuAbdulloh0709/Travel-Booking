package com.epam.TravelBooking.controller;

import com.epam.TravelBooking.model.Flight;
import com.epam.TravelBooking.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FlightControllerTest {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    private MockMvc mockMvc;

    public FlightControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    @Test
    void testGetAllFlights() throws Exception {
        when(flightService.getAllFlights()).thenReturn(Arrays.asList(new Flight()));

        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists());

        verify(flightService, times(1)).getAllFlights();
    }

    @Test
    void testGetAllFlightsException() throws Exception {
        when(flightService.getAllFlights()).thenThrow(new RuntimeException("Flight service not reachable"));

        mockMvc.perform(get("/flights"))
                .andExpect(status().isInternalServerError());

        verify(flightService, times(1)).getAllFlights();
    }
}
