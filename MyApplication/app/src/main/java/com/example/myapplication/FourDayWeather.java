
package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FourDayWeather {

    @GET( "/data/2.5/forecast" )
    Call<Weather_class> GetForecastByCityName(@Query( "q" ) String city, @Query( "appid" ) String appID);
    //Call<Example> get_phoenetics(@Path("word") String word);

}
