package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.AuctionDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This interface provides the contract for the Auction Service implementation
 * this provides the business logic for the application and
 * exposes a public contract for the actual service implementation, without
 * implementation details such as private methods or attributes
 */
@Component
public interface AuctionService {
    /**
     * These methods must be fully implemented in the actual service class
     */
    void saveAuction(AuctionDto auctionDto);
    Auction findByStart_dateAndEnd_dateAndSellerAndFlight(LocalDateTime start, LocalDateTime end, User seller, Flight flight);
    List<AuctionDto> findAllAuctions();
}
