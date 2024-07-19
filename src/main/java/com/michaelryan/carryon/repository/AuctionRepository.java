package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Auction findByStartDateAndEndDateAndSellerAndFlight(ZonedDateTime start, ZonedDateTime end, User seller, Flight flight);
}
