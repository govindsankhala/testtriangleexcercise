package com.gss.weatherforecast.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.R;
import com.gss.weatherforecast.UseCaseHandler;
import com.gss.weatherforecast.data.WeatherRepository;
import com.gss.weatherforecast.data.local.WeatherLocalDataSource;
import com.gss.weatherforecast.data.remote.WeatherRemoteDataSource;
import com.gss.weatherforecast.util.Constants;
import com.gss.weatherforecast.util.ProgressDialogManager;
import com.gss.weatherforecast.weather.adapter.WeatherForecastAdapter;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;
import com.gss.weatherforecast.weather.domain.usecase.GetWeatherForecast;

public class WeatherForecastActivity extends AppCompatActivity implements WeatherForecastContract.View {

    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecycleView = findViewById(R.id.rvWeatherForecast);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        WeatherForecastPresenter presenter = new WeatherForecastPresenter(
                UseCaseHandler.getInstance(),
                new GetWeatherForecast(WeatherRepository.getInstance(WeatherRemoteDataSource.getInstance(this),
                        WeatherLocalDataSource.getInstance(this))),
                this);

        presenter.getWeatherForecastData(Constants.CITY_ID, Constants.APP_ID);
    }

    @Override
    public void displayData(WeatherForecastResponse data) {
        if (data != null && data.getStatus().equals("200")) {
            mRecycleView.setAdapter(new WeatherForecastAdapter(this, data.getList()));
        } else {
            Toast.makeText(this, " No weather record found.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void displayError(ErrorResponse errorResponse) {
        Toast.makeText(this, errorResponse.getStatus() + " error, while retrieving weather forecast data.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {
        ProgressDialogManager.showProgressDialog(this, "loading...", false);
    }

    @Override
    public void dismissProgressDialog() {
        ProgressDialogManager.dismissProgressDialog();
    }
}
