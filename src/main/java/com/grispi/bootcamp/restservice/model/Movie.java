package com.grispi.bootcamp.restservice.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    private String imdbKey;


    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Genre> genreList = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Player> playerList = new HashSet<>();

    protected Movie() {
    }

    public Movie(String name, String imdbKey, Set<Genre> genreList, Set<Player> playerList) {
        this.name = name;
        this.imdbKey = imdbKey;
        this.genreList = genreList;
        this.playerList = playerList;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getImdbKey() {
        return imdbKey;
    }

    public Set<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(Set<Genre> genreList) {
        this.genreList = genreList;
    }

    public Set<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(Set<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "name: "+getName()+" imdbKey: "+getImdbKey();
    }
}
