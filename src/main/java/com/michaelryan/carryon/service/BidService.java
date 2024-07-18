package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.BidDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Bid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BidService {
    void saveBid(BidDto newBidDto);
    Bid findByAuctionAndBid_amount(Auction auction, Double amount);
    List<BidDto> findAllBids();
}
