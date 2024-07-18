package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Auction findByStart_dateAndEnd_dateAndSellerAndFlight(ZonedDateTime start, ZonedDateTime end, String seller, Flight flight);
}
