package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.ZonedDateTime;

@Data public class BidDto {
    private long id;

    private ZonedDateTime bid_time;

    @Min(0)
    private Double bid_amount;
}
