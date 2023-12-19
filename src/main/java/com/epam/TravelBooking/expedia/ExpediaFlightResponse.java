package com.epam.TravelBooking.expedia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpediaFlightResponse {
    private String airline;
    private String flightNumber;
    private Date departureTime;
    private Date arrivalTime;
    private double price;
}

