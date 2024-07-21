package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class AuctionDto {

    private Long id;

    @Min(1)
    private Double reserve;

    @Min(1)
    private Double start_price;

    @Min(0)
    private Double sale_price;

    private ZonedDateTime start_date;

    private ZonedDateTime end_date;

    private boolean active;
}
