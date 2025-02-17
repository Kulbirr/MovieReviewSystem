package com.example.movieReviewSystem.Response;

import com.example.movieReviewSystem.Entities.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class MovieResponse {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    private String title;

    private String genre;

    private int releaseYear;

    List<Review> reviewList;

    public MovieResponse(String title, String genre, int releaseYear, List<Review> reviewList) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.reviewList = reviewList;
    }

    public MovieResponse() {
    }
}
