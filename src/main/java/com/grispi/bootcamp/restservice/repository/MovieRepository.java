package com.grispi.bootcamp.restservice.repository;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.model.dtos.MovieWithGenreDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {



}
