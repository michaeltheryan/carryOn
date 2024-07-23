package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.FlightDto;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.repository.FlightRepository;
import com.michaelryan.carryon.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        flight.setFlightNumber(flightDto.getFlight_number());
        flight.setAirlineCode(flightDto.getAirline_code());
        flight.setAirportCodeDeparture(flightDto.getAirportCodeDeparture());
        flight.setAirportGateDeparture(flightDto.getAirport_gate_departure());
        flight.setAirportTerminalDeparture(flightDto.getAirport_terminal_departure());
        flight.setAirportCodeArrival(flightDto.getAirportCodeArrival());
        flight.setAirportGateArrival(flightDto.getAirport_gate_arrival());
        flight.setAirportTerminalArrival(flightDto.getAirport_terminal_arrival());
        flight.setAircraftModel(flightDto.getAircraft_model());
        flight.setDeparture(flightDto.getDeparture());
        flight.setArrival(flightDto.getArrival());
        flightRepository.save(flight);
    }

    @Override
    public Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDateTime flightDate) {
        return flightRepository.findByFlightNumberAndDeparture(flightNumber, flightDate);
    }

    @Override
    public List<FlightDto> findAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map((flight) -> convertEntityToDto(flight)).
                collect(Collectors.toList());
    }

    public List<FlightDto> findAllFlightsByDate(String departureAirport, String arrivalAirport,
                                                LocalDateTime departureDate) {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().filter((flight -> flight.getAirportCodeDeparture().equals(departureAirport)))
                .filter((flight -> flight.getAirportCodeArrival().equals(arrivalAirport)))
                .filter((flight -> flight.getDeparture().getMonth().equals(departureDate.getMonth())))
                .filter((flight -> flight.getDeparture().getDayOfMonth() == departureDate.getDayOfMonth()))
                .map((flight -> convertEntityToDto(flight)))
                .collect(Collectors.toList());
    }

    public FlightDto convertEntityToDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlight_number(flight.getFlightNumber());
        flightDto.setAirline_code(flight.getAirlineCode());
        flightDto.setAirportCodeDeparture(flight.getAirportCodeDeparture());
        flightDto.setAirport_gate_departure(flight.getAirportGateDeparture());
        flightDto.setAirport_terminal_departure(flight.getAirportTerminalDeparture());
        flightDto.setAirportCodeArrival(flight.getAirportCodeArrival());
        flightDto.setAirport_gate_arrival(flight.getAirportGateArrival());
        flightDto.setAirport_terminal_arrival(flight.getAirportTerminalArrival());
        flightDto.setAircraft_model(flight.getAircraftModel());
        flightDto.setDeparture(flight.getDeparture());
        flightDto.setArrival(flight.getArrival());
        return flightDto;
    }
}
