package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Genre;
import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("movies")
public class MovieController {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("")
    public List<Movie> getMovies(){

        return (List<Movie>) movieRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        
        movieRepository.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("/{id}")
    Movie getOneMovie(@PathVariable Long id){
        return movieRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("movie with " + id + " doesn't exist"));
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable long id){
        boolean movieExists = movieRepository.existsById(id);
        if(!movieExists){
            throw new IllegalStateException(
                    "Movie with " + id + " doesn't exists"
            );
        }
        movieRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateGenreofMovie(@PathVariable long id,@RequestBody Movie movie){
         Movie temp = movieRepository.findById(id).orElseThrow(() -> new IllegalStateException());
         temp.setGenres(movie.getGenres());
         movieRepository.save(temp);
         return ResponseEntity.status(HttpStatus.OK).body(movieRepository.save(temp));
    }

}
