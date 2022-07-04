package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {
    private final List<Movie> movies = new ArrayList<>();

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movies;
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        movies.add(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
}
