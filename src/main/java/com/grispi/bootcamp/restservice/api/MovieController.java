package com.grispi.bootcamp.restservice.api;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies/")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping ("movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovie();
    }

}
