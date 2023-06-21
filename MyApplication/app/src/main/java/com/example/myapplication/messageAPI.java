package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface messageAPI {
    @GET("https://api.dictionaryapi.dev/api/v2/entries/en/hello")
    Call<String> message();
    String str = "https://api.dictionaryapi.dev/api/v2/entries/en";
//    @GET ( "/data/2.5/weather" )
    //Call<Example> getWeatherByCityName(@Query( "q" ) String city, @Query ( "appid" ) String appID);

}
