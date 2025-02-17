package com.example.movieReviewSystem.Exceptions;

public class ReviewDoesntExist extends RuntimeException{
    public ReviewDoesntExist(String message) {
        super(message);
    }
}
