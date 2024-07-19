package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.BidDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Bid;
import com.michaelryan.carryon.repository.BidRepository;
import com.michaelryan.carryon.service.BidService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService {
    private BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public void saveBid(BidDto newBidDto) {
        Bid newBid = new Bid();
        newBid.setBidTime(newBidDto.getBid_time());
        newBid.setBidAmount(newBidDto.getBid_amount());
        bidRepository.save(newBid);
    }

    @Override
    public Bid findByAuctionAndBid_amount(Auction auction, Double amount) {
        return bidRepository.findByAuctionAndBidAmount(auction, amount);
    }

    @Override
    public List<BidDto> findAllBids() {
        List<Bid> bids = bidRepository.findAll();
        return bids.stream().map((bid) -> convertEntityToDto(bid)).
                collect(Collectors.toList());
    }

    private BidDto convertEntityToDto(Bid entity) {
        BidDto dto = new BidDto();
        dto.setBid_time(entity.getBidTime());
        dto.setBid_amount(entity.getBidAmount());
        return dto;
    }
}
