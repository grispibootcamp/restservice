package com.grispi.bootcamp.restservice.model.dtos;

public class MovieWithGenreDto {

    private Long id;
    private String movieName;
    private String genreName;

    protected MovieWithGenreDto() {

    }

    public MovieWithGenreDto(Long id, String movieName, String genreName) {
        this.id = id;
        this.movieName = movieName;
        this.genreName = genreName;
    }
}
