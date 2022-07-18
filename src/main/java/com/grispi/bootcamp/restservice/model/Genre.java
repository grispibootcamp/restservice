package com.grispi.bootcamp.restservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    protected Genre(){

    }

    public Genre(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
  @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();


    public Set<Movie> getMovies(){

        return movies;
    }
}
