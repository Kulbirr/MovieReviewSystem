package com.example.movieReviewSystem.Service;


import com.example.movieReviewSystem.DTO.MovieDto;
import com.example.movieReviewSystem.Entities.Movie;
import com.example.movieReviewSystem.Exceptions.SameMovieException;
import com.example.movieReviewSystem.Repository.MovieRepository;
import com.example.movieReviewSystem.Response.AddMovieResponse;
import com.example.movieReviewSystem.Response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public AddMovieResponse addMovie(MovieDto movieDto) {
        Optional<Movie> movieOptional = movieRepository.findByTitle(movieDto.getTitle());

        if(movieOptional.isPresent()){
            throw new SameMovieException("Movie with same name found");
        }
        Movie movie = new Movie();
        movie.setGenre(movieDto.getGenre());
        movie.setTitle(movieDto.getTitle());
        movie.setReleaseYear(movieDto.getReleaseYear());

        movieRepository.save(movie);
        AddMovieResponse addMovieResponse = new AddMovieResponse(movieDto.getTitle(), "Movie added successfully!");

        return addMovieResponse;
    }

    @Override
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();

        List<MovieResponse> movieResponseList = new ArrayList<>();
        for(Movie movie : movieList){
            MovieResponse movieResponse = new MovieResponse(movie.getTitle(), movie.getGenre(),
                    movie.getReleaseYear(), movie.getReviews());
            movieResponseList.add(movieResponse);
        }

        return new ResponseEntity<>(movieResponseList, HttpStatus.OK);
    }
}
