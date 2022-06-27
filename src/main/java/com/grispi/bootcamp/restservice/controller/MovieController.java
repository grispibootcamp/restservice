package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Greeting;
import com.grispi.bootcamp.restservice.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private static final List<Movie> movies = new ArrayList();

    @GetMapping("/movies")
    public List<Movie> list(@RequestParam(value = "name", defaultValue = "Undefined") String name, @RequestParam(value = "imdbKey", defaultValue = "Undefined") String imdbKey) {

        return movies;
    }

    @PostMapping("/movies")
    public Movie create(@RequestParam(value = "name", defaultValue = "NaN Name") String name, @RequestParam(value = "imdbKey", defaultValue = "Undefined") String imdbKey) {

        Movie m = new Movie(name, imdbKey);

        movies.add(m);
        return m;
    }

}
