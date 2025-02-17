package com.example.movieReviewSystem.Service;

import com.example.movieReviewSystem.Entities.Movie;
import com.example.movieReviewSystem.Entities.Review;
import com.example.movieReviewSystem.Exceptions.ReviewDoesntExist;
import com.example.movieReviewSystem.Repository.MovieRepository;
import com.example.movieReviewSystem.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public Review addReview(Long movieId, Review review) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        review.setMovie(movie);
        return reviewRepository.save(review);
    }

    public Review updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewDoesntExist("Review not found"));
        review.setComment(updatedReview.getComment());
        review.setRating(updatedReview.getRating());
        return reviewRepository.save(review);
    }
}
