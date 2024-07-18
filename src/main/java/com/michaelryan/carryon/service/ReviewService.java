package com.michaelryan.carryon.service;

import com.michaelryan.carryon.dto.ReviewDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReviewService {
    void saveReview(ReviewDto reviewDto);
    Review findByAuction(Auction auction);
    List<ReviewDto> findAllReviews();
}
