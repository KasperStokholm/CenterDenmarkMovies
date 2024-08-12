package com.example.CDMovies.controller;

import com.example.CDMovies.model.Movie;
import com.example.CDMovies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public Iterable<Movie> getMovies(){
        return movieService.read();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovies(@PathVariable Integer id){
        if(movieService.read(id) != null) {
            return movieService.read(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("updateMovie/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
        if(movieService.read(id) != null){
            movieService.create(movie);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteMovie/{id}")
    public void deleteMovie(@PathVariable Integer id){
        if(movieService.read(id) != null){
            movieService.remove(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createMovie")
    public void addMovie(@RequestBody Movie movie){
        movieService.create(movie);
    }
}
