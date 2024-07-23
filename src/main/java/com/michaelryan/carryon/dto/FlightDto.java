package com.michaelryan.carryon.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class defines the attributes for Flight Data Transfer Objects which
 * are used to carry multiple data attributes between processes
 */
@Data
public class FlightDto {
    private Long id;

    private String flight_number;

    private String airline_code;

    //@NotEmpty
    private String airportCodeDeparture;

    private String airport_terminal_departure;

    //@NotEmpty
    private String airportCodeArrival;

    private String airport_terminal_arrival;

    private String aircraft_model;

    private LocalDateTime departure;

    private LocalDateTime arrival;

}
