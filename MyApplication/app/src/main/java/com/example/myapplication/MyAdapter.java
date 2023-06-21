package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {



    private Example mData;//список даних, які будемо розміщувати в RecyclerView
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    // передаємо дані в конструктор
    MyAdapter(Context context, Example data) {

        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }
    // “створює(надуває)” рядок(пункт) RecyclerView з xml файлу
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layoutstringitem2, parent, false);
        return new ViewHolder(view);
    }
    // заповнює кожен рядок RecyclerView даними
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String jk = mData.getValue();
        holder.myJoke.setText(jk);
        String url = mData.getIconUrl();
        //url = "https://lh3.googleusercontent.com/7lSZNQtnNRjCYdEKI202S55K-_Rja3ujtljXEQdcXUoh8TDSppLOjU4fzxVFakPbUhD1nw-pW7qju4qs02fSYgUP=w640-h400-e365-rj-sc0x00ffffffhttps://lh3.googleusercontent.com/7lSZNQtnNRjCYdEKI202S55K-_Rja3ujtljXEQdcXUoh8TDSppLOjU4fzxVFakPbUhD1nw-pW7qju4qs02fSYgUP=w640-h400-e365-rj-sc0x00ffffff";
        url = "https://www.shutterstock.com/image-vector/thin-line-snap-finger-like-260nw-1070110487.jpg";
        Picasso picasso = Picasso.get();
        picasso.load(url)
                .into(holder.img);

    }
    // загальна кількість рядків
    @Override
    public int getItemCount() {
        return 1;
    }
    // зберігає та використовує view компоненти, коли рядок прокручується (виходить з екрана)
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //public BreakIterator myTextView;
        EditText myJoke;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);

            myJoke = itemView.findViewById(R.id.joke);
            img = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    // отримання даних з рядка RecyclerView, за яким клацнули
    Example getItem(int id) {
        return mData;
    }
    // додавання можливості перехата натискання на кнопку
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    //  Activity буде реалізовувати цей метод, клацання по елементу
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
