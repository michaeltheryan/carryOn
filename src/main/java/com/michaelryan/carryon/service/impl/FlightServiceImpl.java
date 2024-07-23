package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.FlightDto;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.repository.FlightRepository;
import com.michaelryan.carryon.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the corresponding service interface and provides the
 * business logic (go-between for the controller/web layer and the data access
 * layer (repository, DAO, etc.) for Auctions
 */
@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    /**
     * constructor
     */
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    /**
     * method to save new Flights
     */
    @Override
    public void saveFlight(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDto.getFlight_number());
        flight.setAirlineCode(flightDto.getAirline_code());
        flight.setAirportCodeDeparture(flightDto.getAirportCodeDeparture());
        flight.setAirportTerminalDeparture(flightDto.getAirport_terminal_departure());
        flight.setAirportCodeArrival(flightDto.getAirportCodeArrival());
        flight.setAirportTerminalArrival(flightDto.getAirport_terminal_arrival());
        flight.setAircraftModel(flightDto.getAircraft_model());
        flight.setDeparture(flightDto.getDeparture());
        flight.setArrival(flightDto.getArrival());
        flightRepository.save(flight);
    }

    /**
     * method to find Flights by number and date
     */
    @Override
    public Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDateTime flightDate) {
        return flightRepository.findByFlightNumberAndDeparture(flightNumber, flightDate);
    }

    /**
     * method to find all Flights
     */
    @Override
    public List<FlightDto> findAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map((flight) -> convertEntityToDto(flight)).
                collect(Collectors.toList());
    }

    /**
     * method to find all Flights on a given day
     */
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

    /**
     * method to convert Flights to Dtos for client interactions
     */
    public FlightDto convertEntityToDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlight_number(flight.getFlightNumber());
        flightDto.setAirline_code(flight.getAirlineCode());
        flightDto.setAirportCodeDeparture(flight.getAirportCodeDeparture());
        flightDto.setAirport_terminal_departure(flight.getAirportTerminalDeparture());
        flightDto.setAirportCodeArrival(flight.getAirportCodeArrival());
        flightDto.setAirport_terminal_arrival(flight.getAirportTerminalArrival());
        flightDto.setAircraft_model(flight.getAircraftModel());
        flightDto.setDeparture(flight.getDeparture());
        flightDto.setArrival(flight.getArrival());
        return flightDto;
    }
}
