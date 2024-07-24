package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the attributes for User Entities (POJOs) which
 * representing table data that can be persisted in the database
 */
@Entity
@Table(name = "users")
@Data
public class User {
    /**
     * Each attribute represents a column in the table
     */
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")}
    )
    private List<Role> roles = new ArrayList<>();
}
