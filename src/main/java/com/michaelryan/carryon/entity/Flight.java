package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String flight_number;

    @Column(nullable = false)
    private String airline_code;

    @Column(nullable = false)
    private String airport_code_departure;

    @Column(nullable = false)
    private String airport_terminal_departure;

    @Column(nullable = false)
    private String airport_gate_departure;

    @Column(nullable = false)
    private String airport_code_arrival;

    @Column(nullable = false)
    private String airport_terminal_arrival;

    @Column(nullable = false)
    private String airport_gate_arrival;

    @Column(nullable = false)
    private String aircraft_model;

    @Column(nullable = false)
    private ZonedDateTime departure;

    @Column(nullable = false)
    private ZonedDateTime arrival;

    @OneToMany(mappedBy = "flight")
    private List<Auction> auctions;
}
