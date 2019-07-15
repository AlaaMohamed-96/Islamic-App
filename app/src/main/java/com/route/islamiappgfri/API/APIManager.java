package com.route.islamiappgfri.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {
    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("http://api.mp3quran.net/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static WebServices getApis(){
        return  getInstance().create(WebServices.class);
    }
}
