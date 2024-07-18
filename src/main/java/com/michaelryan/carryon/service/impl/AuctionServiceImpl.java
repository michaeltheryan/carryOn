package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.AuctionDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.repository.AuctionRepository;
import com.michaelryan.carryon.service.AuctionService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuctionServiceImpl implements AuctionService {
    private AuctionRepository auctionRepository;

    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public void saveAuction(AuctionDto auctionDto) {
        Auction auction = new Auction();
        auction.setReserve(auctionDto.getReserve());
        auction.setStart_price(auctionDto.getStart_price());
        auction.setSale_price(auctionDto.getSale_price());
        auction.setStart_date(auctionDto.getStart_date());
        auction.setEnd_date(auctionDto.getEnd_date());
        auction.setActive(auctionDto.isActive());
        auctionRepository.save(auction);
    }

    @Override
    public Auction findByStart_dateAndEnd_dateAndSellerAndFlight(ZonedDateTime start, ZonedDateTime end, String seller, Flight flight) {
        return auctionRepository.findByStart_dateAndEnd_dateAndSellerAndFlight(start, end, seller, flight);
    }

    @Override
    public List<AuctionDto> findAllAuctions() {
        List<Auction> auctions = auctionRepository.findAll();
        return auctions.stream().map((auction) -> convertEntityToDto(auction)).
                collect(Collectors.toList());
    }

    private AuctionDto convertEntityToDto(Auction auction){
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setReserve(auction.getReserve());
        auctionDto.setStart_price(auction.getStart_price());
        auctionDto.setSale_price(auction.getSale_price());
        auctionDto.setStart_date(auction.getStart_date());
        auctionDto.setEnd_date(auction.getEnd_date());
        auctionDto.setActive(auction.isActive());
        return auctionDto;
    }
}
