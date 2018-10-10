package com.gss.weatherforecast.data;

import android.support.annotation.NonNull;

import com.gss.weatherforecast.DataSourceCallBack;
import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

import static com.google.common.base.Preconditions.checkNotNull;

/*
 * Weather repository
 * */

public class WeatherRepository implements WeatherDataSource {

    @SuppressWarnings("unused")
    private final String TAG = this.getClass().getName();
    private static WeatherRepository instance = null;
    @SuppressWarnings("unused")
    private final WeatherDataSource weatherRemoteDateSource;
    private final WeatherDataSource weatherLocalDataSource;

    private WeatherRepository(@NonNull WeatherDataSource weatherRemoteDateSource, @NonNull WeatherDataSource weatherLocalDataSource) {
        this.weatherRemoteDateSource = checkNotNull(weatherRemoteDateSource, " Remote Weather Data Source cannot be null");
        this.weatherLocalDataSource = checkNotNull(weatherLocalDataSource, " Local Weather Data Source cannot be null");
    }

    public static WeatherRepository getInstance(WeatherDataSource weatherRemoteDateSource, WeatherDataSource weatherLocalDataSource) {
        if (instance == null) {
            instance = new WeatherRepository(weatherRemoteDateSource, weatherLocalDataSource);
        }
        return instance;
    }

    @Override
    public void getWeatherForecastingData(String cityId, String appId, DataSourceCallBack<WeatherForecastResponse, ErrorResponse> dataSourceCallBack) {
        // can determine whether data to be retrieve local db or to retrieve from remote server
        // can retrieve the data from local storage if available # weatherLocalDataSource
        weatherRemoteDateSource.getWeatherForecastingData(cityId, appId, dataSourceCallBack);
    }
}
