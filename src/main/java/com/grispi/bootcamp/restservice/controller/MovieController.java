package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/movies/")
public class MovieController {

    private MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @GetMapping("")
    public List<Movie> getMovies()
    {
        return (List<Movie>) movieRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id) {

        Optional<Movie> movie = movieRepository.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(movie);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Movie> deleteMovieById (@PathVariable Long id) {
        try {
            movieRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateGenreOfMovie(@PathVariable Long id, @RequestBody Movie movie) {
        try {
            movieRepository.save(movie);
            return ResponseEntity.status(HttpStatus.OK).body(movie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movie);
        }
    }




}