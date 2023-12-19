package com.epam.TravelBooking.service.impl;

import com.epam.TravelBooking.model.Hotel;
import com.epam.TravelBooking.repository.HotelRepository;
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

class HotelServiceImplTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelServiceImpl hotelService;

    public HotelServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        when(hotelRepository.findAll()).thenReturn(hotels);

        List<Hotel> result = hotelService.getAllHotels();

        assertEquals(hotels, result);
    }

    @Test
    void getHotelById() {
        long hotelId = 1L;
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        Hotel result = hotelService.getHotelById(hotelId);

        assertEquals(hotel, result);
    }

    @Test
    void saveHotel() {
        Hotel hotel = new Hotel();
        when(hotelRepository.save(any())).thenReturn(hotel);

        Hotel result = hotelService.saveHotel(new Hotel());

        assertEquals(hotel, result);
    }

    @Test
    void deleteHotel() {
        long hotelId = 1L;

        hotelService.deleteHotel(hotelId);

        verify(hotelRepository, times(1)).deleteById(hotelId);
    }

    @Test
    void searchHotels() {
        String location = "City";
        List<Hotel> hotels = new ArrayList<>();
        when(hotelRepository.findByLocation(location)).thenReturn(hotels);

        List<Hotel> result = hotelService.searchHotels(location);

        assertEquals(hotels, result);
    }
}
