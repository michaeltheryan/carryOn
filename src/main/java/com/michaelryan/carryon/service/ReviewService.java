package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.ReviewDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Review;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This interface provides the contract for the Review Service implementation
 * this provides the business logic for the application and
 * exposes a public contract for the actual service implementation, without
 * implementation details such as private methods or attributes
 */
@Component
public interface ReviewService {
    /**
     * These methods must be fully implemented in the actual service class
     */
    void saveReview(ReviewDto reviewDto);
    Review findByAuction(Auction auction);
    List<ReviewDto> findAllReviews();
}
