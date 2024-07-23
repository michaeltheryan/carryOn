package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.ReviewDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Review;
import com.michaelryan.carryon.repository.ReviewRepository;
import com.michaelryan.carryon.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements the corresponding service interface and provides the
 * business logic (go-between for the controller/web layer and the data access
 * layer (repository, DAO, etc.) for Auctions
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    /**
     * constructor
     */
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * method to convert Reviews to Dtos for client interactions
     */
    private ReviewDto convertEntityToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setBuyer_rating(review.getBuyer_rating());
        reviewDto.setSeller_rating(review.getSeller_rating());
        return reviewDto;
    }

    /**
     * method to save new Reviews
     */
    @Override
    public void saveReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setBuyer_rating(reviewDto.getBuyer_rating());
        review.setSeller_rating(reviewDto.getSeller_rating());
        reviewRepository.save(review);
    }

    /**
     * method to find Reviews by auction
     */
    @Override
    public Review findByAuction(Auction auction) {
        return reviewRepository.findByAuction(auction);
    }

    /**
     * method to find all Reviews
     */
    @Override
    public List<ReviewDto> findAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map((review) -> convertEntityToDto(review)).
                collect(Collectors.toList());
    }
}
