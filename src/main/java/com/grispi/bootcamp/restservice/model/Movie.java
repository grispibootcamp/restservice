package com.grispi.bootcamp.restservice.model;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    private String name;

    private String imdbKey;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Genre> genreList = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Player> playerList = new HashSet<>();

}
