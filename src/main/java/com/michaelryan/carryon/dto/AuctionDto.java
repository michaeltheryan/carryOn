package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class defines the attributes for Auction Data Transfer Objects which
 * are used to carry multiple data attributes between processes
 */
@Data
public class AuctionDto {

    private Long id;

    @Min(1)
    private Double reserve;

    @Min(1)
    private Double startPrice;

    @Min(0)
    private Double salePrice;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean active;
}
