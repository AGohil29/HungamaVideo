package com.example.arunr.hungamavideo.Rest;

import com.example.arunr.hungamavideo.Model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by arun.r on 14-03-2018.
 */

public interface ApiInterface {

    @GET
    Call<MovieResponse> getMovieDetails(@Url String url);
}
