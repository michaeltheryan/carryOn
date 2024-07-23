package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDto {
    private Long id;

    private String flight_number;

    private String airline_code;

    //@NotEmpty
    private String airportCodeDeparture;

    private String airport_terminal_departure;

    private String airport_gate_departure;

    //@NotEmpty
    private String airportCodeArrival;

    private String airport_terminal_arrival;

    private String airport_gate_arrival;

    private String aircraft_model;

    private LocalDateTime departure;

    private LocalDateTime arrival;

}
