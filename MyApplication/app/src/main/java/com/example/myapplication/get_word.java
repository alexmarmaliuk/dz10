package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class get_word extends AppCompatActivity  implements MyAdapter.ItemClickListener {
    RecyclerView myrecyclerView;
    final MyAdapter[] adapter = new MyAdapter[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_get_word);
        Bundle bundle = getIntent().getExtras();
        String my_word = (bundle.get("Key")).toString();
        myrecyclerView=findViewById(R.id.myrecyclerview);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl( "https://api.chucknorris.io" )// базова частина адреси
            .addConverterFactory(GsonConverterFactory. create ())// конвертер
            .build();

    get_my_joke word_api;
        //Log.i("QQQ", "rgar");
    word_api=retrofit.create(get_my_joke.class );// створили об'єкт , за його допомогою будемо відправляти запити
        //Log.i("EEE", "rgar");

        word_api.get_joke(my_word).enqueue(new Callback<Example>() {// асинхронний виклик (для синхронного був би метод execute() )
    @Override
    public void onResponse(Call<Example> call, Response<Example> response) {
        if (response.isSuccessful()) {
            adapter[0] = new MyAdapter(getApplicationContext(), response.body());
            adapter[0].setClickListener(get_word.this::onItemClick);
            myrecyclerView.setAdapter(adapter[0]);
            Log. i ( "Oleksandr" , response.body().getValue());
            Log. i ( "Oleksandr" , response.body().getId() +" "+ response.raw().request().url());
            Log. i ( "Oleksandr" , "OK" );
        } else {Log. i ( "Oleksandr" , "no reponse" ); Log.i("TAG", "Response: " + response.raw().request().url());}
    }
    @Override
    public void onFailure(Call<Example> call, Throwable t) {
        Log. i ( "Oleksandr" , "Failure" +t);

    }
});

}
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}