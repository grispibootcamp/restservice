package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){

        return (List<Movie>) movieRepository.findAll();
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){

        movieRepository.save(movie);
//        movies.add(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("/movies/{id}")
    Movie getOneMovie(@PathVariable Long id){
        return movieRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("movie with " + id + " doesn't exist"));
    }

    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable long id){
        boolean movieExists = movieRepository.existsById(id);
        if(!movieExists){
            throw new IllegalStateException(
                    "Movie with " + id + " doesn't exists"
            );
        }
        movieRepository.deleteById(id);
    }
}
