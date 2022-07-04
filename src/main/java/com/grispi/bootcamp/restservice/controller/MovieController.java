package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAll();
    }


    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        return new ResponseEntity(movieRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping("/movies/remove")
    public ResponseEntity<Movie> removeMovie(@RequestBody Movie movie) {
        movieRepository.delete(movie);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }






}