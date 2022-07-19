package com.grispi.bootcamp.restservice.controller;
import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.model.Player;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController

@RequestMapping("movies")
public class MovieController {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("")
    public List<Movie> getMovies(){

        return (List<Movie>) movieRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){

        movieRepository.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("/{id}")
    Movie getOneMovie(@PathVariable Long id){
        return movieRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("movie with " + id + " doesn't exist"));
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable long id){
        boolean movieExists = movieRepository.existsById(id);
        if(!movieExists){
            throw new IllegalStateException(
                    "Movie with " + id + " doesn't exists"
            );
        }
        movieRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateGenreofMovie(@PathVariable long id,@RequestBody Movie movie){
         Movie temp = movieRepository.findById(id).orElseThrow(() -> new IllegalStateException());
         temp.setGenres(movie.getGenres());
         return ResponseEntity.status(HttpStatus.OK).body(movieRepository.save(temp));
    }

    @PostMapping("/{id}/players")
    public ResponseEntity<Movie> addPlayertoMovie(@PathVariable long id, @RequestBody Player player){
        Movie temp = movieRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        temp.getPlayers().add(player);
        return ResponseEntity.status(HttpStatus.OK).body(movieRepository.save(temp));
    }

    @GetMapping("/{id}/players")
    ResponseEntity<Set<Player>> getPlayersOfMovie(@PathVariable long id){
        Movie temp = movieRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        return ResponseEntity.status(HttpStatus.OK).body(temp.getPlayers());
    }

}
