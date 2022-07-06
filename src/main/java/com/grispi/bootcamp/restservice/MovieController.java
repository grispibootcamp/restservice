package com.grispi.bootcamp.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    private static final List<Movie> movies = new ArrayList();

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movies;
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> newMovie(@RequestBody Movie movie){

        Movie m = new Movie(movie.getName(),movie.getImdbKey());
        movies.add(m);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(m);
    }


}
