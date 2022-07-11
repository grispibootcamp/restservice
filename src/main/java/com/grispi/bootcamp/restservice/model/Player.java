package com.grispi.bootcamp.restservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;
    @Column(name = "player_name")
    private String name;
    @ManyToMany(mappedBy = "players")
    private List<Movie> movies;

    protected Player() {

    }

    public Player(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
