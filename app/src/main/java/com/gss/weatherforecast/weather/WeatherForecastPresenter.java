package com.gss.weatherforecast.weather;

import android.support.annotation.NonNull;

import com.gss.weatherforecast.UseCase;
import com.gss.weatherforecast.UseCaseHandler;
import com.gss.weatherforecast.weather.domain.usecase.GetWeatherForecast;

import static com.google.common.base.Preconditions.checkNotNull;

public class WeatherForecastPresenter implements WeatherForecastContract.Presenter {

    private static final String TAG = "LoginPresenter";
    private final UseCaseHandler useCaseHandler;
    private final GetWeatherForecast getWeatherForecastUseCase;
    private final WeatherForecastContract.View view;


    public WeatherForecastPresenter(@NonNull UseCaseHandler useCaseHandler,
                          @NonNull GetWeatherForecast getWeatherForecastUseCase,
                          @NonNull WeatherForecastContract.View view) {
        this.useCaseHandler = checkNotNull(useCaseHandler, "useCaseHandler cannot be null!");
        this.getWeatherForecastUseCase = checkNotNull(getWeatherForecastUseCase, "getWeatherForecastUseCase cannot be null!");
        this.view = checkNotNull(view, "view cannot be null!");
    }

    @Override
    public void getWeatherForecastData(String cityId, String appId) {
        view.showProgressDialog();
        final GetWeatherForecast.RequestValues requestValues = new GetWeatherForecast.RequestValues(cityId, appId);
        useCaseHandler.execute(getWeatherForecastUseCase, requestValues, new UseCase.UseCaseCallback<GetWeatherForecast.ResponseValue>() {
            @Override
            public void onSuccess(GetWeatherForecast.ResponseValue response) {
                view.dismissProgressDialog();
                view.displayData(response.getData());
            }

            @Override
            public void onError(GetWeatherForecast.ResponseValue response) {
                view.dismissProgressDialog();
                view.displayError(response.getError());
            }
        });
    }
}
