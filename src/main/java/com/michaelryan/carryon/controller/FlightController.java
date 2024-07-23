package com.michaelryan.carryon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.michaelryan.carryon.config.CustomFlightDeserializer;
import com.michaelryan.carryon.dto.FlightDto;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * This class defines the Controller for the Flight Entity which controls
 * navigation to endpoints that require a Flight Entity DTO
 */
@Controller
public class FlightController {
    private FlightService flightService;
    private final String FLIGHT_URL = "https://flight-info-api.p.rapidapi.com/schedules?version=v2";
    private CustomFlightDeserializer customFlightDeserializer;

    /**
     * constructor
     */
    @Autowired
    public FlightController(FlightService flightService, WebClient webClient) {
        this.flightService = flightService;
        this.customFlightDeserializer = new CustomFlightDeserializer();
    }

    /**
     * Method mapped to search_flights endpoint
     */
    @GetMapping("/search_flights")
    public String searchFlights(Model model) {
        FlightDto flightDto = new FlightDto();
        model.addAttribute("flightDto", flightDto);
        return "search_flights";
    }

    /**
     * Method mapped to search_flights endpoint
     */
    @JsonDeserialize(using = CustomFlightDeserializer.class)
    @GetMapping("/search_flights/save")
    public String search(@Valid @ModelAttribute("flight") FlightDto flightDto,
                         BindingResult bindingResult, Model model) {
        ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(configurer -> {
                    configurer.defaultCodecs()
                            .jackson2JsonDecoder(new Jackson2JsonDecoder(new ObjectMapper(), MediaType.APPLICATION_JSON));
                    configurer.defaultCodecs()
                            .jackson2JsonEncoder(new Jackson2JsonEncoder(new ObjectMapper(), MediaType.APPLICATION_JSON));
                }).build();
        String finalUrl = FLIGHT_URL + flightDto.getDeparture() +
                "&DepartureAirport=" + flightDto.getAirportCodeDeparture() +
                "&ArrivalAirport=" + flightDto.getAirportCodeArrival() +
                "&CodeType=IATA";
        WebClient client = WebClient.builder()
                .baseUrl(finalUrl)
                .defaultHeaders(httpHeaders -> {
                    //httpHeaders.addAll(createHeaders());
                })
                .exchangeStrategies(strategies)
                .build();

        Mono<List<Flight>> response = client.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Flight>>() {});
        List<Flight> flights = response.block();

        List<FlightDto> existing = flightService.findAllFlightsByDate(flightDto.getAirportCodeDeparture(),
                flightDto.getAirportCodeArrival(), flightDto.getDeparture());
        if (existing != null) {
            model.addAttribute("flightDto", existing);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("flightDto", flightDto);
            return "search";
        }
        if(flights != null) {
            flights.forEach((flight -> flightService.saveFlight(flightService.convertEntityToDto(flight))));
        }
        model.addAttribute("flightDto", flights);
        return "search_results";
    }

    /**
     * Method mapped to search_results endpoint
     */
    @GetMapping("/search_results")
    public String searchResults() {
        return "search_results";
    }
    /*
     */
/*

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", "486869d47dmsha4ec7b5284f7eafp18412ajsnb1821000eacc");
        headers.add("x-rapidapi-host", "flight-info-api.p.rapidapi.com");
        return headers;
    }
*/
}
