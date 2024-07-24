package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.AuctionDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Flight;
import com.michaelryan.carryon.entity.User;
import com.michaelryan.carryon.repository.AuctionRepository;
import com.michaelryan.carryon.service.AuctionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the corresponding service interface and provides the
 * business logic (go-between for the controller/web layer and the data access
 * layer (repository, DAO, etc.) for Auctions
 */
@Service
public class AuctionServiceImpl implements AuctionService {
    private AuctionRepository auctionRepository;

    /**
     * constructor
     */
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    /**
     * method to save new Auctions
     */
    @Override
    public void saveAuction(AuctionDto auctionDto) {
        Auction auction = new Auction();
        auction.setReserve(auctionDto.getReserve());
        auction.setStartPrice(auctionDto.getStartPrice());
        auction.setSalePrice(auctionDto.getSalePrice());
        auction.setStartDate(auctionDto.getStartDate());
        auction.setEndDate(auctionDto.getEndDate());
        auction.setActive(auctionDto.isActive());
        auctionRepository.save(auction);
    }

    /**
     * method to find Auctions by start date/time, end date/time, and seller
     */
    @Override
    public Auction findByStartDateAndEndDateAndSellerAndFlight(LocalDateTime start, LocalDateTime end, User seller, Flight flight) {
        return auctionRepository.findByStartDateAndEndDateAndSellerAndFlight(start, end, seller, flight);
    }

    /**
     * method to find all Auctions
     */
    @Override
    public List<AuctionDto> findAllAuctions() {
        List<Auction> auctions = auctionRepository.findAll();
        return auctions.stream().map((auction) -> convertEntityToDto(auction)).
                collect(Collectors.toList());
    }

    /**
     * method to convert Auctions to Dtos for client interactions
     */
    private AuctionDto convertEntityToDto(Auction auction){
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setReserve(auction.getReserve());
        auctionDto.setStartPrice(auction.getStartPrice());
        auctionDto.setSalePrice(auction.getSalePrice());
        auctionDto.setStartDate(auction.getStartDate());
        auctionDto.setEndDate(auction.getEndDate());
        auctionDto.setActive(auction.isActive());
        return auctionDto;
    }
}
