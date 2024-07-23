package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
public class Flight {
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
    private String airportGateDeparture;

    @Column
    @NotNull
    private String airportCodeArrival;

    @Column
    @NotNull
    private String airportTerminalArrival;

    @Column
    @NotNull
    private String airportGateArrival;

    @Column
    @NotNull
    private String aircraftModel;

    @Column
    private LocalDateTime departure;

    @Column
    private LocalDateTime arrival;

    @OneToMany(mappedBy = "flight")
    private List<Auction> auctions;
}
