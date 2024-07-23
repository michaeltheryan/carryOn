package com.michaelryan.carryon.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.michaelryan.carryon.entity.Flight;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * This is a class to convert received JSON data to an Entity
 */
public class CustomFlightDeserializer extends StdDeserializer<Flight> {

    /**
     * no-args constructor
     */
    public CustomFlightDeserializer() {
        this(null);
    }

    /**
     * constructor that accepts Flight Entity class as an argument
     */
    public CustomFlightDeserializer(Class<Flight> t) {
        super(t);
    }

    /**
     * This method finds the pertinent values in the JSON response and
     * assigns each value to the relevant attribute of a newly created
     * Entity object, returning the object when complete
     */
    @Override
    public Flight deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        Flight flight = new Flight();
        ObjectCodec oc = p.getCodec();
        JsonNode node = oc.readTree(p);

        JsonNode number = node.get("flightNumber");
        flight.setFlightNumber(number.asText());

        JsonNode airline = node.get("iata");
        flight.setAirlineCode(airline.asText());

        JsonNode departureCode = node.get("departure.airport.iata");
        flight.setAirportCodeDeparture(departureCode.asText());

        JsonNode departureTerminal = node.get("departure.terminal");
        flight.setAirportTerminalDeparture(departureTerminal.asText());

        JsonNode arrivalCode = node.get("arrival.airport.iata");
        flight.setAirportCodeArrival(arrivalCode.asText());

        JsonNode arrivalTerminal = node.get("arrival.terminal");
        flight.setAirportTerminalDeparture(departureTerminal.asText());

        JsonNode model = node.get("aircraftType.iata");
        flight.setAircraftModel(departureTerminal.asText());

        flight.setDeparture(LocalDateTime.parse(node.get("departure.date.utc").toString() +
                "T" + node.get("departure.time.utc").toString()));

        return flight;
    }
}
