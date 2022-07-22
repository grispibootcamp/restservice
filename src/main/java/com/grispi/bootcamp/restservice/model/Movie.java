package com.grispi.bootcamp.restservice.model;



import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imdbKey;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Genre> genreList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Player> playerList = new ArrayList<>();

    protected Movie() {
    }

    public Movie(String name, String imdbKey, List<Genre> genreList, List<Player> playerList) {
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

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "name: "+getName()+" imdbKey: "+getImdbKey();
    }
}
