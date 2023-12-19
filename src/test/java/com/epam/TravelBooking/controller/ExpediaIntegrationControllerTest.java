package com.epam.TravelBooking.controller;

import com.epam.TravelBooking.expedia.ExpediaFlightResponse;
import com.epam.TravelBooking.service.ExpediaIntegrationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ExpediaIntegrationControllerTest {

    @Mock
    private ExpediaIntegrationService expediaIntegrationService;

    @InjectMocks
    private ExpediaIntegrationController expediaIntegrationController;

    private MockMvc mockMvc;

    public ExpediaIntegrationControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(expediaIntegrationController).build();
    }

    @Test
    void testGetFlightAvailability() throws Exception {
        when(expediaIntegrationService.getFlightAvailability(anyString(), anyString(), any(Date.class)))
                .thenReturn(Arrays.asList(new ExpediaFlightResponse()));

        mockMvc.perform(get("/expedia/flights")
                .param("origin", "CityA")
                .param("destination", "CityB")
                .param("departureDate", "2023-01-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].airline").exists());

        verify(expediaIntegrationService, times(1))
                .getFlightAvailability(eq("CityA"), eq("CityB"), any(Date.class));
    }

    // Similar tests for getHotelAvailability and getRentalCarAvailability

    // Test for handling exceptions
    @Test
    void testFlightAvailabilityException() throws Exception {
        when(expediaIntegrationService.getFlightAvailability(anyString(), anyString(), any(Date.class)))
                .thenThrow(new RuntimeException("Expedia API not reachable"));

        mockMvc.perform(get("/expedia/flights")
                .param("origin", "CityA")
                .param("destination", "CityB")
                .param("departureDate", "2023-01-01"))
                .andExpect(status().isInternalServerError());

        verify(expediaIntegrationService, times(1))
                .getFlightAvailability(eq("CityA"), eq("CityB"), any(Date.class));
    }

}
