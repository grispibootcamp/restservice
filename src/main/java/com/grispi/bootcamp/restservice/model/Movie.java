package com.grispi.bootcamp.restservice.model;


import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false, name = "imdb_key")
    private String imdbKey;

    protected Movie() {
    }

    public Movie(String name, String imdbKey) {
        this.name = name;
        this.imdbKey = imdbKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImdbKey() {
        return imdbKey;
    }

    public Long getId() {
        return id;
    }

    public void setImdbKey(String imdbKey) {
        this.imdbKey = imdbKey;
    }

    @Override
    public String toString() {
        return "Movie [name=" + name + ", imdbKey=" + imdbKey + "]";
    }



}
