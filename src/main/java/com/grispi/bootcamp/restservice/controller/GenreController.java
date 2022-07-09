package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.entity.Genre;
import com.grispi.bootcamp.restservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public Iterable<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        genreRepository.save(genre);
        return new ResponseEntity<>(genre, HttpStatus.CREATED);
    }



}
