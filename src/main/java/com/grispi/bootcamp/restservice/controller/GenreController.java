package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Genre;
import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {
    @Autowired
    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("")
    public List<Genre> getGenres(){

        return (List<Genre>) genreRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre){

        genreRepository.save(genre);

        return ResponseEntity.status(HttpStatus.CREATED).body(genre);
    }

}
