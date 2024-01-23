package com.movie.api.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movie.api.model.Movie;
import com.movie.api.repository.MovieRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    @Override
    public void populateMoviesFromCSV(MultipartFile file) {
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
        	 String[] header = csvReader.readNext(); // Read and skip the header row
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                // Assuming CSV format: title,releaseYear
                if (record.length == 8) {
                    Movie movie = new Movie();
                    movie.setTitle(record[0].trim());
                    movie.setReleaseYear(Integer.parseInt(record[1].trim()));
                    movie.setImdbRating(Float.parseFloat(record[2].trim())); 
                    movie.setAbout(record[2].trim()); 
                    movie.setProducer(record[3].trim()); 
                    movie.setDirector(record[4].trim()); 
                    // Set other attributes as needed
                    movieRepository.save(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        } catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void deleteAllMovies() {
        movieRepository.deleteAll();
    }
}