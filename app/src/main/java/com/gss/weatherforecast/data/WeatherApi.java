package com.gss.weatherforecast.data;

import com.gss.weatherforecast.util.Constants;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface WeatherApi {

    @GET(Constants.WEATHER_FORECAST_END_POINT)
    Observable<WeatherForecastResponse> getWeatherForecastData(@Query("id") String cityId, @Query("appid") String appId);

}
