package com.example.movieReviewSystem.Controller;

import com.example.movieReviewSystem.DTO.MovieDto;
import com.example.movieReviewSystem.Entities.Movie;
import com.example.movieReviewSystem.Repository.MovieRepository;
import com.example.movieReviewSystem.Response.AddMovieResponse;
import com.example.movieReviewSystem.Response.MovieResponse;
import com.example.movieReviewSystem.Service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movie")
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddMovieResponse> addMovie(@RequestBody MovieDto movieDto) {

        try{
            AddMovieResponse addMovieResponse = movieService.addMovie(movieDto);
            return new ResponseEntity<>(addMovieResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-movies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
            return movieService.getAllMovies();
    }


}
