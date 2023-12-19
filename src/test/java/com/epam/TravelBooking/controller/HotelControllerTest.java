package com.epam.TravelBooking.controller;

import com.epam.TravelBooking.model.Hotel;
import com.epam.TravelBooking.service.HotelService;
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

class HotelControllerTest {

    @Mock
    private HotelService hotelService;

    @InjectMocks
    private HotelController hotelController;

    private MockMvc mockMvc;

    public HotelControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
    }

    @Test
    void testGetAllHotels() throws Exception {
        when(hotelService.getAllHotels()).thenReturn(Arrays.asList(new Hotel()));

        mockMvc.perform(get("/hotels"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists());

        verify(hotelService, times(1)).getAllHotels();
    }

    // Similar tests for other CRUD methods and edge cases

    // Test for handling exceptions
    @Test
    void testGetAllHotelsException() throws Exception {
        when(hotelService.getAllHotels()).thenThrow(new RuntimeException("Hotel service not reachable"));

        mockMvc.perform(get("/hotels"))
                .andExpect(status().isInternalServerError());

        verify(hotelService, times(1)).getAllHotels();
    }
}
