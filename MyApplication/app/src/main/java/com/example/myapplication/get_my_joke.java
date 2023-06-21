package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface get_my_joke {
    @GET ( "/jokes/random" )
    Call<Example> get_joke(@Query( "category" ) String word);
    //Call<Example> get_phoenetics(@Path("word") String word);

}
