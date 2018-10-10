package com.gss.weatherforecast.weather;

import com.gss.weatherforecast.BasePresenter;
import com.gss.weatherforecast.BaseView;
import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

public interface WeatherForecastContract {
    interface View extends BaseView<Presenter> {

        void displayData(WeatherForecastResponse data);

        void displayError(ErrorResponse errorResponse);

    }

    interface Presenter extends BasePresenter {

        void getWeatherForecastData(String cityId, String appId);

    }
}
