package com.grispi.bootcamp.restservice.model;



import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "movie_imdbKey")
    private String imdbKey;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_player",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players = new HashSet<>();


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

    public Set<Genre> getGenres() {
        return genres;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}