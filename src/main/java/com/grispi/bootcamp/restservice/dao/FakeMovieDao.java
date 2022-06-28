package com.grispi.bootcamp.restservice.dao;

import com.grispi.bootcamp.restservice.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeMovieDao implements MovieDao{

    private List<Movie> DB = new ArrayList<>();


    @Override
    public int insertMovie(UUID id, Movie movie) {
        DB.add(new Movie(id,movie.getName(),movie.getImdb()));
        return 1;
    }

    @Override
    public List<Movie> selectAllMovie() {
        return DB;
    }
}
