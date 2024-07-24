package com.michaelryan.carryon.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 * This class defines the attributes for Review Data Transfer Objects which
 * are used to carry multiple data attributes between processes
 */
@Data
public class ReviewDto {
    private Long id;

    @Min(0)
    @Max(10)
    private Integer buyerRating;

    @Min(0)
    @Max(10)
    private Integer sellerRating;
}
