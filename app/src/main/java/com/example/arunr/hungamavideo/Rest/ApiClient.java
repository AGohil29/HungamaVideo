package com.example.arunr.hungamavideo.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arun.r on 14-03-2018.
 */

public class ApiClient {

    public static final String BASE_URL = "https://n-pvt.hungama.com/v2/content/movieapp/queue_data.json?device=1080x1920&section_id=1&genre=Gossip&bucket_id=5360&offset=0&user_type=1&version=2.0.10.7&app-id=e3MH8F20cr&limit=10&cp=33682232";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
