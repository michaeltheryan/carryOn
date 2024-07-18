package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "auctions")
@Data
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double reserve;

    @Column
    @NotNull
    private Double start_price;

    @Column
    private Double sale_price;

    @Column
    @NotNull
    private ZonedDateTime start_date;

    @Column
    @NotNull
    private ZonedDateTime end_date;

    @Column
    @NotNull
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToMany(mappedBy = "id")
    private List<Bid> bids;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "auction_review", joinColumns = {@JoinColumn(name = "auction_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "review_id", referencedColumnName = "id")})
    private Review review;
}
