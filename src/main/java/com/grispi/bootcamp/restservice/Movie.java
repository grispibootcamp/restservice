package com.grispi.bootcamp.restservice;

import java.util.concurrent.atomic.AtomicInteger;

public class Movie {

    private static final AtomicInteger counter = new AtomicInteger(
            0);
    private final int id;

    private final String name;
    private final String imdbKey;

    public Movie(String name, String imdbKey) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.imdbKey = imdbKey;
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImdbKey() {
        return imdbKey;
    }


}
