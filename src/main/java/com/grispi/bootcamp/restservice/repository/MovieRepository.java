package com.grispi.bootcamp.restservice.repository;

import com.grispi.bootcamp.restservice.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
