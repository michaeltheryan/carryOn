package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * This class defines the attributes for Review Entities (POJOs) which
 * representing table data that can be persisted in the database
 */
@Data
@Entity
@Table(name = "reviews")
public class Review {
    /**
     * Each attribute represents a column in the table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer buyerRating;

    @Column
    private Integer sellerRating;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private User seller;

    @OneToOne(mappedBy = "review")
    private Auction auction;

}
