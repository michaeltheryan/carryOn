package com.michaelryan.carryon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FlightWebConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://flight-info-api.p.rapidapi.com/schedules?version=v2&DepartureDateTime=")
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.addAll(createHeaders());
                })
                .build();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", "486869d47dmsha4ec7b5284f7eafp18412ajsnb1821000eacc");
        headers.add("x-rapidapi-host", "flight-info-api.p.rapidapi.com");
        return headers;
    }
}
