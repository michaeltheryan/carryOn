package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This class defines the attributes for Flight Entities (POJOs) which
 * representing table data that can be persisted in the database
 */
@Entity
@Table(name = "flights")
@Data
public class Flight {
    /**
     * Each attribute represents a column in the table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String flightNumber;

    @Column
    @NotNull
    private String airlineCode;

    @Column
    @NotNull
    private String airportCodeDeparture;

    @Column
    @NotNull
    private String airportTerminalDeparture;

    @Column
    @NotNull
    private String airportCodeArrival;

    @Column
    @NotNull
    private String airportTerminalArrival;

    @Column
    private String aircraftModel;

    @Column
    private LocalDateTime departure;

    @Column
    private LocalDateTime arrival;

    @OneToMany(mappedBy = "flight")
    private List<Auction> auctions;
}
