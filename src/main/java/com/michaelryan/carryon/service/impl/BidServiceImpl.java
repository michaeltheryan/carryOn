package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.BidDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Bid;
import com.michaelryan.carryon.repository.BidRepository;
import com.michaelryan.carryon.service.BidService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.ZoneOffset.UTC;

/**
 * This class implements the corresponding service interface and provides the
 * business logic (go-between for the controller/web layer and the data access
 * layer (repository, DAO, etc.) for Bids
 */
@Service
public class BidServiceImpl implements BidService {
    private BidRepository bidRepository;

    /**
     * constructor
     */
    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    /**
     * method to save new Bids
     */
    @Override
    public void saveBid(BidDto newBidDto) {
        Bid newBid = new Bid();
        newBid.setBidTime(LocalDateTime.now(UTC));
        newBid.setBidAmount(newBidDto.getBid_amount());
        bidRepository.save(newBid);
    }

    /**
     * method to find Bids by auction and amount
     */
    @Override
    public Bid findByAuctionAndBid_amount(Auction auction, Double amount) {
        return bidRepository.findByAuctionAndBidAmount(auction, amount);
    }

    /**
     * method to find all Bids
     */
    @Override
    public List<BidDto> findAllBids() {
        List<Bid> bids = bidRepository.findAll();
        return bids.stream().map((bid) -> convertEntityToDto(bid)).
                collect(Collectors.toList());
    }

    /**
     * method to convert Bids to Dtos for client interactions
     */
    private BidDto convertEntityToDto(Bid entity) {
        BidDto dto = new BidDto();
        dto.setBid_time(entity.getBidTime());
        dto.setBid_amount(entity.getBidAmount());
        return dto;
    }
}
