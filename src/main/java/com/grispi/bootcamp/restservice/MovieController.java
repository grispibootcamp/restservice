package com.grispi.bootcamp.restservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MovieController {
    private ArrayList<Movie> movies = new ArrayList<>();

    @GetMapping("/movie")
    public String getList(){
        ArrayList<String> temp = new ArrayList<>();
        for(Movie movieItem:movies){
            temp.add(movieItem.getName());
        }
        return temp.toString();
    }

    @PostMapping("/movie")
    public String addItem(@RequestBody() String name, String imdbKey){
        Movie temp = new Movie(name,imdbKey);
        movies.add(temp);
        return ("Successfully added " + temp.getName() + " !");
    }
}
