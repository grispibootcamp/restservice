package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


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

    @GetMapping("/movies/")
    public ResponseEntity<Optional<Movie>> getById(@RequestParam("id") Long id){
        if (movieRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(movieRepository.findById(id));
        }
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/movies/")
    public ResponseEntity<?> deleteById(@RequestParam("id") Long id){
        if (movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
