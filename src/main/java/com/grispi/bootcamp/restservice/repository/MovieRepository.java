package com.grispi.bootcamp.restservice.repository;

import com.grispi.bootcamp.restservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByName(String name);

    List<Movie> findByImdbKey(String imdbKey);

}
