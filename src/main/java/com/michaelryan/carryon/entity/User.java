package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id")
    private List<Bid> bids;

    @OneToMany(mappedBy = "buyer")
    private List<Review> buyerReviews;

    @OneToMany(mappedBy = "seller")
    private List<Review> sellerReviews;

    @OneToMany(mappedBy = "seller")
    private List<Auction> auctions;
}
