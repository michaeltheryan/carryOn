package com.michaelryan.carryon.repository;

import com.michaelryan.carryon.entity.Auction;
import com.michaelryan.carryon.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByAuction(Auction auction);
}
