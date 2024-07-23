package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface provides the contract for Spring Data Abstraction to
 * implement - this enables abstraction that hides application logic from
 * non-necessary access
 */
@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    Bid findByAuctionAndBidAmount(Auction auction, Double amount);
}
