package com.epam.TravelBooking.expedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpediaRentalCarResponse {
    private String brand;
    private String model;
    private Date pickupDate;
    private Date returnDate;
    private double pricePerDay;
}
