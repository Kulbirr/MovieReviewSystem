package com.example.movieReviewSystem.Response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class AddMovieResponse {
    private String movieName;

    private String message;

    public AddMovieResponse(String movieName, String message) {
        this.movieName = movieName;
        this.message = message;
    }

    public AddMovieResponse() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
