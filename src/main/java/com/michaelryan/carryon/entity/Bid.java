package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class defines the attributes for Bid Entities (POJOs) which
 * representing table data that can be persisted in the database
 */
@Entity
@Table(name = "bids")
@Data
public class Bid {
    /**
     * Each attribute represents a column in the table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Min(0)
    private LocalDateTime bidTime;

    @Column
    @Min(0)
    private double bidAmount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
