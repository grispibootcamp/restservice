package com.grispi.bootcamp.restservice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imdbKey;

    protected Movie() {
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_player",
            joinColumns = { @JoinColumn(name="movie_id")},
            inverseJoinColumns = { @JoinColumn(name = "player_id")}
    )
    private Set<Player> players = new HashSet<>();


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_genre",
           joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") })


    private Set<Genre> genres = new HashSet<>();

    public Set<Genre> getGenres(){
        return genres;
    }
    public Set<Player> getPlayers(){
        return players;
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

    public void setGenres(Set<Genre> genre) {
        this.genres = genre;

    }

    public void setPlayers(Set<Player> player) {
        this.players = player;

    }
}
