package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    private ZonedDateTime created;

    @OneToMany(mappedBy = "id")
    private List<Bid> bids;

    @OneToMany(mappedBy = "buyer")
    private List<Review> buyerReviews;

    @OneToMany(mappedBy = "seller")
    private List<Review> sellerReviews;

    @OneToMany(mappedBy = "seller")
    private List<Auction> auctions;
}
