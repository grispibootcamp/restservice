package com.grispi.bootcamp.restservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String imdbKey;

    protected Movie() {
    }

    public Movie(String name, String imdbKey) {
        this.name = name;
        this.imdbKey = imdbKey;
    }

    public Long getId() { return id; }

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