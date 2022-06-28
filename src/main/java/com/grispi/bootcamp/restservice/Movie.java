package com.grispi.bootcamp.restservice;


public class Movie {
    private String name;
    private String imdbKey;
    public Movie(String name,String imdbKey){
        this.name = name;
        this.imdbKey = imdbKey;
    }
    public String getName() {return name;}
    public void setName(String name){this.name = name;}
    public String getImdbKey() {return imdbKey;}
    public void setImdbKey(String imdbKey){this.imdbKey = imdbKey;}
}
