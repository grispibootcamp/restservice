package com.grispi.bootcamp.restservice;


public class Movie {
    private String name;
    private String imdbKey;

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
}
