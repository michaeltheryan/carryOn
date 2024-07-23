package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.FlightDto;
import com.michaelryan.carryon.entity.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This interface provides the contract for the Flight Service implementation
 * this provides the business logic for the application and
 * exposes a public contract for the actual service implementation, without
 * implementation details such as private methods or attributes
 */
@Component
public interface FlightService {
    /**
     * These methods must be fully implemented in the actual service class
     */
    void saveFlight(FlightDto flightDto);
    Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDateTime flightDate);
    List<FlightDto> findAllFlightsByDate(String departureCity, String arrivalCity, LocalDateTime flightDate);
    List<FlightDto> findAllFlights();
    FlightDto convertEntityToDto(Flight flight);
}
