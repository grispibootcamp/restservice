package com.grispi.bootcamp.restservice.model;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;



@Entity
@Table(name = "genres")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","genres"})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;
    @Column(name = "genre_name")
    private String name;


    protected Genre() {

    }

    public Genre(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
