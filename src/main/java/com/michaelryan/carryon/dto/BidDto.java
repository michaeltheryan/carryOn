package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Data public class BidDto {
    private long id;

    private LocalDateTime bid_time;

    @Min(0)
    private Double bid_amount;
}
