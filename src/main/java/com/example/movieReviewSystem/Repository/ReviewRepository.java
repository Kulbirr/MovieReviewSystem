package com.example.movieReviewSystem.Repository;

import com.example.movieReviewSystem.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
