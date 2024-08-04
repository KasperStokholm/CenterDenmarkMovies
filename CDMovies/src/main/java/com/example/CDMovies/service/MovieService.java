package com.example.CDMovies.service;

import com.example.CDMovies.model.Movie;
import com.example.CDMovies.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> get(){
        return movieRepository.findAll();
    }

    public Movie get(Integer id){
        return movieRepository.findById(id).orElse(null);
    }

    public void remove(Integer id){
        movieRepository.deleteById(id);
    }

    public void save(Movie movie){
        movieRepository.save(movie);
    }
}
