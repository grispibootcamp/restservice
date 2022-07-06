package com.grispi.bootcamp.restservice;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MovieController
{



    private final AtomicLong counter = new AtomicLong();

    private static final List<Movie> movies = new ArrayList();

    @GetMapping("/movies")
    public List<Movie> list(@RequestParam(value = "name", defaultValue = "World") String name) {

        return movies;
    }

    @PostMapping("/movies")
    public Movie create(@RequestBody Movie movie) {



        movies.add(movie);

        return movie;
    }

   

}
