package com.gss.weatherforecast.data;

import com.gss.weatherforecast.DataSourceCallBack;
import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

/**
 * Weather data source
 */
public interface WeatherDataSource {

    /**
     * Retrieves weather forecast for 5 days with data every 3 hours by city id and app id
     * @param cityId
     * @param appId
     * @dataSourceCallBack call back object
     */
    void getWeatherForecastingData(String cityId, String appId, DataSourceCallBack<WeatherForecastResponse, ErrorResponse> dataSourceCallBack);
}
