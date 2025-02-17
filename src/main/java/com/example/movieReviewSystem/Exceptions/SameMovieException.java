package com.example.movieReviewSystem.Exceptions;

public class SameMovieException extends RuntimeException{
    public SameMovieException(String message){
        super(message);
    }
}
