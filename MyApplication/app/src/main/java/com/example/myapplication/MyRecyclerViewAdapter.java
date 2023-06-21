package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.recyclerview.widget.RecyclerView;



public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private java.util.List<com.example.myapplication.List> mData;//список даних, які будемо розміщувати в RecyclerView
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    // передаємо дані в конструктор
    MyRecyclerViewAdapter(Context context, java.util.List<com.example.myapplication.List> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }
    // “створює(надуває)” рядок(пункт) RecyclerView з xml файлу
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layoutstringitem, parent, false);
        return new ViewHolder(view);
    }
    // заповнює кожен рядок RecyclerView даними
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        double temperature = (mData.get(position).getMain().getTemp()-273);
        holder.myTemp.setText(temperature+"");
        String wind = mData.get(position).getWind().getSpeed().toString();
        holder.myWind.setText(wind);
        //  String url = mData.get(position).getList().get(position).getWeather().get(0).getIcon().toString();
    }
    // загальна кількість рядків
    @Override
    public int getItemCount() {
        return mData.size();
    }
    // зберігає та використовує view компоненти, коли рядок прокручується (виходить з екрана)
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //public BreakIterator myTextView;
        EditText myDate;
        EditText myTemp;
        EditText myWind;

        ImageView img;
        ViewHolder(View itemView) {
            super(itemView);

            myTemp = itemView.findViewById(R.id.temp);
            myWind = itemView.findViewById(R.id.wind);
            img = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    // отримання даних з рядка RecyclerView, за яким клацнули
    com.example.myapplication.List getItem(int id) {
        return mData.get(id);
    }
    // додавання можливості перехата натискання на кнопку
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    //  Activity буде реалізовувати цей метод, клацання по елементу
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemClickListener {
        void onItemClick(List weather);
    }

}