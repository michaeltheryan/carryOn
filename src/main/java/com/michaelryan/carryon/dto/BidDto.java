package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.ZonedDateTime;

@Data public class BidDto {
    private long id;

    @NotEmpty
    private ZonedDateTime bid_time;

    @NotEmpty
    private Double bid_amount;
}
