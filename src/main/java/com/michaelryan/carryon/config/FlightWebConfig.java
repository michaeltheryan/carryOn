package com.michaelryan.carryon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This class performs an api call to a preselected api link
 * It includes the api key
 */
@Configuration
public class FlightWebConfig {
    private final String baseUrl = "https://flight-info-api.p.rapidapi.com/schedules?version=v2&DepartureDateTime=";

    /**
     * This method creates a WebClient, which is a reactive web client introduced
     * in Spring 5 - an interface representing the main entry point for performing
     * web requests in Spring
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://flight-info-api.p.rapidapi.com/schedules?version=v2&DepartureDateTime=")
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.addAll(createHeaders());
                })
                .build();
    }

    /**
     * This is a method that creates the header for the api request and
     * is called in the above method to populate the api header
     */
    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", "486869d47dmsha4ec7b5284f7eafp18412ajsnb1821000eacc");
        headers.add("x-rapidapi-host", "flight-info-api.p.rapidapi.com");
        return headers;
    }
}
