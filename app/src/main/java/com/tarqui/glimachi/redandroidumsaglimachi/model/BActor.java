package com.tarqui.glimachi.redandroidumsaglimachi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by glimachi on 20/09/2017.
 */

public class BActor {
    @SerializedName("title")
    private String nombreActor;
    @SerializedName("person_id")
    private String idActor;
    private String description;
    private BImagen image;

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getIdActor() {
        return idActor;
    }

    public void setIdActor(String idActor) {
        this.idActor = idActor;
    }

    public BImagen getImage() {
        return image;
    }

    public void setImage(BImagen image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}