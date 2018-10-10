package com.gss.weatherforecast.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.R;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

public class WeatherForecastActivity extends AppCompatActivity implements WeatherForecastContract.View {

    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void displayData(WeatherForecastResponse data) {

    }

    @Override
    public void displayError(ErrorResponse errorResponse) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }
}
