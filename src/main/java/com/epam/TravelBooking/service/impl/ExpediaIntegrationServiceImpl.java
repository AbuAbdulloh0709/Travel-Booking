package com.epam.TravelBooking.service.impl;

import com.epam.TravelBooking.expedia.ExpediaFlightResponse;
import com.epam.TravelBooking.expedia.ExpediaHotelResponse;
import com.epam.TravelBooking.expedia.ExpediaRentalCarResponse;
import com.epam.TravelBooking.service.ExpediaIntegrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ExpediaIntegrationServiceImpl implements ExpediaIntegrationService {

    @Value("${expedia.api.url}")
    private String apiUrl;

    @Value("${expedia.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public ExpediaIntegrationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ExpediaFlightResponse> getFlightAvailability(String origin, String destination, Date departureDate) {
        String url = apiUrl + "/flights";
        url = buildUrlWithParameters(url, "origin", origin, "destination", destination, "departureDate", departureDate.toString());

        ExpediaFlightResponse[] responseArray = restTemplate.getForObject(url, ExpediaFlightResponse[].class);
        return Arrays.asList(responseArray);
    }

    @Override
    public List<ExpediaHotelResponse> getHotelAvailability(String location, Date checkInDate, Date checkOutDate) {
        String url = apiUrl + "/hotels";
        url = buildUrlWithParameters(url, "location", location, "checkInDate", checkInDate.toString(), "checkOutDate", checkOutDate.toString());

        ExpediaHotelResponse[] responseArray = restTemplate.getForObject(url, ExpediaHotelResponse[].class);
        return Arrays.asList(responseArray);
    }

    @Override
    public List<ExpediaRentalCarResponse> getRentalCarAvailability(String city, Date pickupDate, Date returnDate) {
        String url = apiUrl + "/rental-cars";
        url = buildUrlWithParameters(url, "city", city, "pickupDate", pickupDate.toString(), "returnDate", returnDate.toString());

        // Make HTTP request using restTemplate
        ExpediaRentalCarResponse[] responseArray = restTemplate.getForObject(url, ExpediaRentalCarResponse[].class);
        return Arrays.asList(responseArray);
    }

    private String buildUrlWithParameters(String baseUrl, Object... params) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        if (params.length > 0) {
            urlBuilder.append("?");
            for (int i = 0; i < params.length; i += 2) {
                urlBuilder.append(params[i]).append("=").append(params[i + 1]);
                if (i < params.length - 2) {
                    urlBuilder.append("&");
                }
            }
        }
        return urlBuilder.toString();
    }
}


