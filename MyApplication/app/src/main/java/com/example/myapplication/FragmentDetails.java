package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentDetails extends Fragment {
    private List Weather;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.details, container, false);
//        TextView dateTextView = view.findViewById(R.id.details_date_textview);
//        TextView temperatureTextView = view.findViewById(R.id.details_temperature_textview);
//        TextView humidityTextView = view.findViewById(R.id.details_humidity_textview);
//        TextView precipitationTextView = view.findViewById(R.id.details_precipitation_textview);
        View view = inflater.inflate(R.layout.details, container, false);
        TextView temperature = view.findViewById(R.id.details_temperature);
        TextView humidity = view.findViewById(R.id.details_humidity);
        TextView wind = view.findViewById(R.id.details_wind);

        if (Weather != null) {

            temperature.setText(Weather.getMain().getTemp().toString());
            humidity.setText(Weather.getMain().getHumidity().toString());
            wind.setText(Weather.getWind().getSpeed().toString());
        }

        return view;
    }

    public void setData(List Weather) {
        this.Weather = Weather;
    }

    public void update(List Weather) {
        View view = getView();
        if (view != null) {
            TextView temperature = view.findViewById(R.id.details_temperature);
            TextView humidity = view.findViewById(R.id.details_humidity);
            TextView wind = view.findViewById(R.id.details_wind);

            if (Weather != null) {
                temperature.setText(Weather.getMain().getTemp().toString());
                humidity.setText(Weather.getMain().getHumidity().toString());
                wind.setText(Weather.getWind().getSpeed().toString());
            }
        }
    }
}

