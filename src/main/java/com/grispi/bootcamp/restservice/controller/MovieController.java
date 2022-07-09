package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.entity.Movie;
import com.grispi.bootcamp.restservice.entity.Player;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id).orElse(null);
        if (movieToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieToUpdate.setName(movie.getName());
        movieToUpdate.setImdbKey(movie.getImdbKey());
        movieToUpdate.setGenres(movie.getGenres());
        movieToUpdate.setPlayers(movie.getPlayers());
        movieRepository.save(movieToUpdate);
        return new ResponseEntity<>(movieToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        Movie movieToDelete = movieRepository.findById(id).orElse(null);
        if (movieToDelete == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieRepository.delete(movieToDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


    @GetMapping("/{id}/players")
    public ResponseEntity<Iterable<Player>> getMoviePlayers(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie.getPlayers(), HttpStatus.OK);
    }

    @PostMapping("/{id}/players")
    public ResponseEntity<Movie> addPlayerToMovie(@PathVariable Long id, @RequestBody Player player) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movie.getPlayers().add(player);
        movieRepository.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


}
