package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.AuctionDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Flight;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

@Component
public interface AuctionService {
    void saveAuction(AuctionDto auctionDto);
    Auction findByStart_dateAndEnd_dateAndSellerAndFlight(ZonedDateTime start, ZonedDateTime end, String seller, Flight flight);
    List<AuctionDto> findAllAuctions();
}
