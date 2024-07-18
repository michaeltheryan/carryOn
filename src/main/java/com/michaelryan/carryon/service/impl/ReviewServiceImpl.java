package com.michaelryan.carryon.service.impl;

import com.michaelryan.carryon.dto.ReviewDto;
import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Review;
import com.michaelryan.carryon.repository.ReviewRepository;
import com.michaelryan.carryon.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    private ReviewDto convertEntityToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setBuyer_rating(review.getBuyer_rating());
        reviewDto.setSeller_rating(review.getSeller_rating());
        return reviewDto;
    }

    @Override
    public void saveReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setBuyer_rating(reviewDto.getBuyer_rating());
        review.setSeller_rating(reviewDto.getSeller_rating());
        reviewRepository.save(review);
    }

    @Override
    public Review findByAuction(Auction auction) {
        return reviewRepository.findByAuction(auction);
    }

    @Override
    public List<ReviewDto> findAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map((review) -> convertEntityToDto(review)).
                collect(Collectors.toList());
    }
}
