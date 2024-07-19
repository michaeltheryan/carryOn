package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightNumberAndDeparture(String flightNumber, ZonedDateTime flightDate);
}
