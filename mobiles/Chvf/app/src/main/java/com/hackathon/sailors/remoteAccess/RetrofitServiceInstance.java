package com.hackathon.sailors.remoteAccess;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceInstance {

    private static Retrofit retrofit;

    private static String baseUrl = "https://pregnancy-data-aggregator.herokuapp.com";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static Api getApi(){
        return  getRetrofitInstance().create(Api.class);
    }

}
