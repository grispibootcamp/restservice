package com.grispi.bootcamp.restservice.model;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "genres")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","genres"})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private Long id;
    @Column(name = "genre_name")
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    protected Genre() {

    }

    public Genre(String name, List<Movie> movies) {
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
