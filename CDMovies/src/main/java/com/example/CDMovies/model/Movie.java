package com.example.CDMovies.model;

import com.example.CDMovies.repository.MovieRepository;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "movies")
public class Movie implements Persistable{

    @org.springframework.data.annotation.Id
    private Integer id;

    private int year;
    private String title, director, rating;

    private Movie() {

    }

    public Movie(Integer id, int year, String title, String director, String rating) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        //Should handle whether a movie is new or not
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
