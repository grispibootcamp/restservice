package com.grispi.bootcamp.restservice.repository;

import com.grispi.bootcamp.restservice.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
