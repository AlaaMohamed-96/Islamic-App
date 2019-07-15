package com.route.islamiappgfri.API;

import com.route.islamiappgfri.API.Model.RadioChannelsResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface WebServices {

    @GET("radios/radio_arabic.json")
    Call<RadioChannelsResponse>  getRadioChannels();
}
