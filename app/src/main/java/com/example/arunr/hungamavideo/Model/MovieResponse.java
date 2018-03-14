package com.example.arunr.hungamavideo.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by arun.r on 14-03-2018.
 */

public class MovieResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("mesage")
    private String message;
    @SerializedName("node")
    private Node node;

    public Node getNode() {
        return node;
    }

    public class Node{
        @SerializedName("epoch")
        private Integer epoch;
        @SerializedName("ts")
        private Integer ts;
        @SerializedName("country")
        private String country;
        @SerializedName("bucketId")
        private Integer bucketId;
        @SerializedName("prioityID")
        private Integer priorityId;
        @SerializedName("data")
        private ArrayList<Movie> data = new ArrayList<>();

        public ArrayList<Movie> getData() {
            return data;
        }

        public void setData(ArrayList<Movie> data) {
            this.data = data;
        }
    }
}
