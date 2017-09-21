package com.tarqui.glimachi.redandroidumsaglimachi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by glimachi on 20/09/2017.
 */


public class BPelicula {
    private String description;
    private String title;
    private String director;
    @SerializedName("imdb_id")
    private String idPelicula; //idPelicula
    private String year;  //Año de lanzamiento pelicula
    private BPoster poster;

    public BPelicula(String description, String title, String director, String idPelicula, String year, BPoster poster) {
        this.description = description;
        this.title = title;
        this.director = director;
        this.idPelicula = idPelicula;
        this.year = year;
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BPoster getPoster() {
        return poster;
    }

    public void setPoster(BPoster poster) {
        this.poster = poster;
    }
}

