package com.grispi.bootcamp.restservice.model;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "genres")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","books"})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private Long id;
    @Column(name = "genre_name")
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;

    protected Genre() {

    }

    public Genre(String names) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
