package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.FlightDto;
import com.michaelryan.carryon.entity.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface FlightService {
    void saveFlight(FlightDto flightDto);
    Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDateTime flightDate);
    List<FlightDto> findAllFlightsByDate(String departureCity, String arrivalCity, LocalDateTime flightDate);
    List<FlightDto> findAllFlights();
    FlightDto convertEntityToDto(Flight flight);
}
