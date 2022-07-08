package com.grispi.bootcamp.restservice.model;


import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long id;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "movie_imdbKey")
    private String imdbKey;
    @ManyToOne()
    @JoinColumn(name = "genre_id")
    private Genre genre;


    protected Movie() {
    }

    public Movie(String name, String imdbKey, Genre genre) {
        this.name = name;
        this.imdbKey = imdbKey;
        this.genre = genre;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getImdbKey() {
        return imdbKey;
    }

    public Genre getGenre() {
        return genre;
    }


    @Override
    public String toString() {
        return "name: "+getName()+" imdbKey: "+getImdbKey();
    }
}