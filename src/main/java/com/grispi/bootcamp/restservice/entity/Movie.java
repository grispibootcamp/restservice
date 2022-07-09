package com.grispi.bootcamp.restservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "imdb_key", nullable = false, unique = true)
    private String imdbKey;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<Genre>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_player", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players = new HashSet<Player>();


    public Movie() {
    }

    public Movie(Long id, String name, String imdbKey, Set<Genre> genres, Set<Player> players) {
        this.id = id;
        this.name = name;
        this.imdbKey = imdbKey;
        this.genres = genres;
        this.players = players;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setImdbKey(String imdbKey) {
        this.imdbKey = imdbKey;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
