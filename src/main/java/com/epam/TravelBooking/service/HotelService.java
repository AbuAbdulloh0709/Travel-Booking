package com.epam.TravelBooking.service;

import com.epam.TravelBooking.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    Hotel getHotelById(Long id);

    Hotel saveHotel(Hotel hotel);

    void deleteHotel(Long id);

    List<Hotel> searchHotels(String location);
}

