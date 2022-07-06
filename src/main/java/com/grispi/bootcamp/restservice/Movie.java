package com.grispi.bootcamp.restservice;



public class Movie
{
    private String imdbKey;
     private String name;

    public Movie(String imdbKey, String name) {
        this.imdbKey = imdbKey;
        this.name = name;
    }

    public String getImdbKey() {
        return imdbKey;
    }

    public String getName() {
        return name;
    }
}
