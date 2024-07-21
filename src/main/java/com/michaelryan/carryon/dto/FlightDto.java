package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class FlightDto {
    private Long id;

    @NotEmpty
    private String flight_number;

    @NotEmpty
    private String airline_code;

    @NotEmpty
    private String airport_code_departure;

    @NotEmpty
    private String airport_terminal_departure;

    @NotEmpty
    private String airport_gate_departure;

    @NotEmpty
    private String airport_code_arrival;

    @NotEmpty
    private String airport_terminal_arrival;

    @NotEmpty
    private String airport_gate_arrival;

    @NotEmpty
    private String aircraft_model;

    private ZonedDateTime departure;

    private ZonedDateTime arrival;

}
