package com.example.arunr.hungamavideo.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by arun.r on 14-03-2018.
 */

public class Movie {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("lang")
    private String lang;
    @SerializedName("lang_id")
    private String langId;
    @SerializedName("genre")
    private String genre;
    @SerializedName("images")
    private ArrayList<Images> images = new ArrayList<>();

    public Movie(String id, String name, String lang, String langId, String genre, ArrayList<Images> images) {
        this.id = id;
        this.name = name;
        this.lang = lang;
        this.langId = langId;
        this.genre = genre;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLang() {
        return lang;
    }

    public String getLangId() {
        return langId;
    }

    public String getGenre() {
        return genre;
    }

    public ArrayList<Images> getImages() {
        return images;
    }

    public class Images{
        @SerializedName("image")
        private String image;

        public Images(String image) {
            this.image = image;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
