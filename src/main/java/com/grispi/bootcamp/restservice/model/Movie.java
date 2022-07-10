package com.grispi.bootcamp.restservice.model;



import javax.persistence.*;
import java.util.List;

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;


    protected Movie() {
    }

    public Movie(String name, String imdbKey, List<Genre> genres) {
        this.name = name;
        this.imdbKey = imdbKey;
        this.genres = genres;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getImdbKey() {
        return imdbKey;
    }

    public List<Genre> getGenre() {
        return genres;
    }


}