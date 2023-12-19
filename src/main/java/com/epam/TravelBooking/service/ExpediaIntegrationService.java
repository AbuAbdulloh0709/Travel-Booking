package com.epam.TravelBooking.service;

import com.epam.TravelBooking.expedia.ExpediaFlightResponse;
import com.epam.TravelBooking.expedia.ExpediaHotelResponse;
import com.epam.TravelBooking.expedia.ExpediaRentalCarResponse;

import java.util.Date;
import java.util.List;

public interface ExpediaIntegrationService {

    List<ExpediaFlightResponse> getFlightAvailability(String origin, String destination, Date departureDate);

    List<ExpediaHotelResponse> getHotelAvailability(String location, Date checkInDate, Date checkOutDate);

    List<ExpediaRentalCarResponse> getRentalCarAvailability(String city, Date pickupDate, Date returnDate);
}

