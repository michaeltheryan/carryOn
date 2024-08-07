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

    private String flightNumber;

    private String airlineCode;

    //@NotEmpty
    private String airportCodeDeparture;

    private String airportTerminalDeparture;

    //@NotEmpty
    private String airportCodeArrival;

    private String airportTerminalArrival;

    private String aircraftModel;

    private LocalDateTime departure;

    private LocalDateTime arrival;

}
