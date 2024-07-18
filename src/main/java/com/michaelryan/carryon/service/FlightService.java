package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.FlightDto;
import com.michaelryan.carryon.entity.Flight;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

@Component
public interface FlightService {
    void saveFlight(FlightDto flightDto);
    Flight findByFlightNumberAndFlightDate(String flightNumber, ZonedDateTime flightDate);
    List<FlightDto> findAllFlights();
}
