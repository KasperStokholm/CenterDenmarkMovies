package com.example.CDMovies.web;

import com.example.CDMovies.model.Movie;
import com.example.CDMovies.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addMovie")
    public void addMovie(@RequestBody Movie movie){
        movieService.save(movie);
    }

}
