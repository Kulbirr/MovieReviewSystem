package com.example.movieReviewSystem.Service;

import com.example.movieReviewSystem.Entities.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    Review addReview(Long movieId, Review review);

    Review updateReview(Long reviewId, Review updatedReview);
}
