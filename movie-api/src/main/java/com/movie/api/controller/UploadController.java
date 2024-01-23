package com.movie.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.movie.api.service.MovieService;

@Controller
@RequestMapping("/api/upload")
public class UploadController {

	@Autowired
    private MovieService movieService;

    @PostMapping("/csv")
    public String handleCSVUpload(@RequestParam("file") MultipartFile file) {
        movieService.populateMoviesFromCSV(file);
        return "redirect:/api/movies"; // Redirect to the movie listing page
    }
}