package com.epam.TravelBooking.expedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpediaHotelResponse {
    private String hotelName;
    private String location;
    private Date checkInDate;
    private Date checkOutDate;
    private double pricePerNight;
}
