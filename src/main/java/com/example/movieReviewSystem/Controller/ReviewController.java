package com.example.movieReviewSystem.Controller;

import com.example.movieReviewSystem.Entities.Review;
import com.example.movieReviewSystem.Service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/review")
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("add/{movieId}")
    public ResponseEntity<Review> addReview(@PathVariable Long movieId, @RequestBody Review review) {
        try{
            return new ResponseEntity(reviewService.addReview(movieId, review), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @PutMapping("update/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        try {
            return new ResponseEntity<>(reviewService.updateReview(reviewId, updatedReview), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CREATED);
        }
    }
}
