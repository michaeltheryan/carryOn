package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * This interface provides the contract for Spring Data Abstraction to
 * implement - this enables abstraction that hides application logic from
 * non-necessary access
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightNumberAndDeparture(String flightNumber, LocalDateTime flightDate);
}
