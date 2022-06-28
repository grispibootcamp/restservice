package com.grispi.bootcamp.restservice.service;

import com.grispi.bootcamp.restservice.dao.MovieDao;
import com.grispi.bootcamp.restservice.model.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(@Qualifier("fakeDao") MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public int addMovie(Movie movie) {
        return movieDao.insertMovie(movie);
    }

    public List<Movie> getAllMovie() {
        return movieDao.selectAllMovie();
    }

}
