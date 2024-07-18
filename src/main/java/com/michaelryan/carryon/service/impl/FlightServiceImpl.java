package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.FlightDto;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.repository.FlightRepository;
import com.michaelryan.carryon.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void saveFlight(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlight_number(flightDto.getFlight_number());
        flight.setAirline_code(flightDto.getAirline_code());
        flight.setAirport_code_departure(flightDto.getAirport_code_departure());
        flight.setAirport_gate_departure(flightDto.getAirport_gate_departure());
        flight.setAirport_terminal_departure(flightDto.getAirport_terminal_departure());
        flight.setAirport_code_arrival(flightDto.getAirport_code_arrival());
        flight.setAirport_gate_arrival(flightDto.getAirport_gate_arrival());
        flight.setAirport_terminal_arrival(flightDto.getAirport_terminal_arrival());
        flight.setAircraft_model(flightDto.getAircraft_model());
        flight.setDeparture(flightDto.getDeparture());
        flight.setArrival(flightDto.getArrival());
        flightRepository.save(flight);
    }

    @Override
    public Flight findByFlightNumberAndFlightDate(String flightNumber, ZonedDateTime flightDate) {
        return flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
    }

    @Override
    public List<FlightDto> findAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map((flight) -> convertEntityToDto(flight)).
                collect(Collectors.toList());
    }

    private FlightDto convertEntityToDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlight_number(flight.getFlight_number());
        flightDto.setAirline_code(flight.getAirline_code());
        flightDto.setAirport_code_departure(flight.getAirport_code_departure());
        flightDto.setAirport_gate_departure(flight.getAirport_gate_departure());
        flightDto.setAirport_terminal_departure(flight.getAirport_terminal_departure());
        flightDto.setAirport_code_arrival(flight.getAirport_code_arrival());
        flightDto.setAirport_gate_arrival(flight.getAirport_gate_arrival());
        flightDto.setAirport_terminal_arrival(flight.getAirport_terminal_arrival());
        flightDto.setAircraft_model(flight.getAircraft_model());
        flightDto.setDeparture(flight.getDeparture());
        flightDto.setArrival(flight.getArrival());
        return flightDto;
    }
}
