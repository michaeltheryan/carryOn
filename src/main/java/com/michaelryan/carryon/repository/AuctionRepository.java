package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * This interface provides the contract for Spring Data Abstraction to
 * implement - this enables abstraction that hides application logic from
 * non-necessary access
 */
@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Auction findByStartDateAndEndDateAndSellerAndFlight(LocalDateTime start, LocalDateTime end, User seller, Flight flight);
}
