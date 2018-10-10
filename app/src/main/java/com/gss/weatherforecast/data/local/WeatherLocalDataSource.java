package com.gss.weatherforecast.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.gss.weatherforecast.DataSourceCallBack;
import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.R;
import com.gss.weatherforecast.data.WeatherDataSource;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;


public class WeatherLocalDataSource implements WeatherDataSource {

    @SuppressWarnings("unused")
    private final String TAG = this.getClass().getName();
    private static WeatherLocalDataSource instance;
    @SuppressWarnings("unused")
    private Context context;

    private WeatherLocalDataSource(@NonNull Context context) {
        this.context = context;
    }

    public static WeatherLocalDataSource getInstance(@NonNull Context context) {
        if (instance == null) {
            instance = new WeatherLocalDataSource(context);
        }
        return instance;
    }

    @Override
    public void getWeatherForecastingData(String cityId, String appId, DataSourceCallBack<WeatherForecastResponse, ErrorResponse> dataSourceCallBack) {
        // here we can write code for retrieving data from local database
        // in our case we are not supporting local data storing, so we throw an error
        throw new UnsupportedOperationException(context.getString(R.string.error_method_not_implemented));
    }
}
