package com.movie.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.movie.api.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

	List<Movie> findByReleaseYearBetween(int startYear, int endYear);

}
