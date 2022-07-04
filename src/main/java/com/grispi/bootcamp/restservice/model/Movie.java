package com.grispi.bootcamp.restservice.model;

public class Movie {
    private final String name;
    private final String imdbKey;

    public Movie(String name, String imdbKey) {
        this.name = name;
        this.imdbKey = imdbKey;
    }

    public String getName() {
        return name;
    }

    public String getImdbKey() {
        return imdbKey;
    }

    @Override
    public String toString() {
        return "name: "+getName()+" imdbKey: "+getImdbKey();
    }
}
