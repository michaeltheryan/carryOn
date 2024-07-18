package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Column
    @NotNull
    private String flight_number;

    @Column
    @NotNull
    private String airline_code;

    @Column
    @NotNull
    private String airport_code_departure;

    @Column
    @NotNull
    private String airport_terminal_departure;

    @Column
    @NotNull
    private String airport_gate_departure;

    @Column
    @NotNull
    private String airport_code_arrival;

    @Column
    @NotNull
    private String airport_terminal_arrival;

    @Column
    @NotNull
    private String airport_gate_arrival;

    @Column
    @NotNull
    private String aircraft_model;

    @Column
    @NotNull
    private ZonedDateTime departure;

    @Column
    @NotNull
    private ZonedDateTime arrival;

    @OneToMany(mappedBy = "flight")
    private List<Auction> auctions;
}
