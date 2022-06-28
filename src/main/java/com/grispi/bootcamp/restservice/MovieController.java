package com.grispi.bootcamp.restservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private static final List<Movie> movies = new ArrayList<>();

    
    @GetMapping("/movies")
    public List<Movie> list() {
		return movies;
	}
    @PostMapping("/movies")
	public Movie create(@RequestBody Movie movie) {
		movies.add(movie);
		return movie;
	}
}
