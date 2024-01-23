package com.movie.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.movie.api.model.Movie;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie addMovie(Movie movie);
    
    void deleteAllMovies();
    
    void populateMoviesFromCSV(MultipartFile file);
}