package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
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

    @Min(0)
    @Column
    private Double startPrice;

    @Column
    private Double salePrice;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private User seller;

    @Getter
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
