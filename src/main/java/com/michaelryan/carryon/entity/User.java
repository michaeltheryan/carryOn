package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String email;

    @Column
    @NotEmpty
    private String password;

    @Column
    private LocalDateTime created;

    @OneToMany(mappedBy = "id")
    private List<Bid> bids;

    @OneToMany(mappedBy = "buyer")
    private List<Review> buyerReviews;

    @OneToMany(mappedBy = "seller")
    private List<Review> sellerReviews;

    @OneToMany(mappedBy = "seller")
    private List<Auction> auctions;
}
