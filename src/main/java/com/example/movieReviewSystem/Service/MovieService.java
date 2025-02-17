package com.example.movieReviewSystem.Service;

import com.example.movieReviewSystem.DTO.MovieDto;
import com.example.movieReviewSystem.Entities.Movie;
import com.example.movieReviewSystem.Response.AddMovieResponse;
import com.example.movieReviewSystem.Response.MovieResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    AddMovieResponse addMovie(MovieDto movieDto);

    ResponseEntity<List<MovieResponse>> getAllMovies();
}
