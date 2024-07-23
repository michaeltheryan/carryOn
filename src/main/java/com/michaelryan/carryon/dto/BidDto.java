package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class defines the attributes for Bid Data Transfer Objects which
 * are used to carry multiple data attributes between processes
 */
@Data public class BidDto {
    private long id;

    private LocalDateTime bid_time;

    @Min(0)
    private Double bid_amount;
}
