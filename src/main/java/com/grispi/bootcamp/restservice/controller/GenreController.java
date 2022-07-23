package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Genre;
import com.grispi.bootcamp.restservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres/")
public class GenreController {

    private GenreRepository genreRepository;

    @Autowired
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("")
    public List<Genre> getAllGenres() {
        return (List<Genre>) genreRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        genreRepository.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genre);
    }


}
