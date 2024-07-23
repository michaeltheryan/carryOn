package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.BidDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Bid;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This interface provides the contract for the Bid Service implementation
 * this provides the business logic for the application and
 * exposes a public contract for the actual service implementation, without
 * implementation details such as private methods or attributes
 */
@Component
public interface BidService {
    /**
     * These methods must be fully implemented in the actual service class
     */
    void saveBid(BidDto newBidDto);
    Bid findByAuctionAndBid_amount(Auction auction, Double amount);
    List<BidDto> findAllBids();
}
