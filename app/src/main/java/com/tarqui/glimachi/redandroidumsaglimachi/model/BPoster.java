package com.tarqui.glimachi.redandroidumsaglimachi.model;

/**
 * Created by glimachi on 20/09/2017.
 */

public class BPoster {
    String large;
    String thumb;

    public BPoster(String large, String thumb) {
        this.large = large;
        this.thumb = thumb;
    }

    public BPoster() {
        this.large = "";
        this.thumb = "";
    }
    public BPoster(BPoster poster) {
        this.large = poster.getLarge();
        this.thumb = poster.getThumb();
    }
    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}