package com.grispi.bootcamp.restservice.repository;

import com.grispi.bootcamp.restservice.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.genreList g LEFT JOIN FETCH m.playerList p")
    Set<Movie> findAllWithRelations();
}
