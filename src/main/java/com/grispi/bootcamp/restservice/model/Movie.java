package com.grispi.bootcamp.restservice.model;

import java.util.UUID;

public class Movie {

    private final UUID id;
    private final String name;
    private final String imdb;

    public Movie(UUID id, String name, String imdb) {
        this.id = id;
        this.name = name;
        this.imdb = imdb;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImdb() {
        return imdb;
    }
}
