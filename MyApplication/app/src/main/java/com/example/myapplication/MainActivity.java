package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl("https://dictionaryapi.dev/")
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//        messageAPI messageAPI=retrofit.create(messageAPI.class);
//        Call<String> message=messageAPI.message();
//        message.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("oleksandr",""+response.body());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.i("oleksandr","Failure"+t);
//            }
//        });
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button1);//описали змінну та зв’язали її з кнопкою
        EditText A = findViewById(R.id.edit1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,get_word.class);
                intent.putExtra( "Key" , A.getText().toString());
                startActivity(intent);
            }
        });

        Button button2=findViewById(R.id.button2);//описали змінну та зв’язали її з кнопкою
        EditText B = findViewById(R.id.edit2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra( "key" , B.getText().toString());
                startActivity(intent);
            }
        });

    }
}