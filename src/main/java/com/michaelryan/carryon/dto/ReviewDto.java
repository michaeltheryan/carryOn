package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ReviewDto {
    private Long id;

    @Min(0)
    @Max(10)
    private Integer buyer_rating;

    @Min(0)
    @Max(10)
    private Integer seller_rating;
}
