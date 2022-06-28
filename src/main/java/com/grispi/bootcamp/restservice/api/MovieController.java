package com.grispi.bootcamp.restservice.api;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie/")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping ("addMovie")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @GetMapping("getAll")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovie();
    }

}
