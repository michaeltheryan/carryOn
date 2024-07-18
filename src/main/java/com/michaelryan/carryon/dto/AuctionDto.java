package com.michaelryan.carryon.dto;

// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty
    private ZonedDateTime start_date;

    @NotEmpty
    private ZonedDateTime end_date;

    @NotEmpty
    private boolean active;
}
