package com.gss.weatherforecast.weather.domain.usecase;

import com.gss.weatherforecast.DataSourceCallBack;
import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.UseCase;
import com.gss.weatherforecast.data.WeatherDataSource;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

import static com.google.common.base.Preconditions.checkNotNull;

public class GetWeatherForecast extends UseCase<GetWeatherForecast.RequestValues, GetWeatherForecast.ResponseValue> {

    @SuppressWarnings("unused")
    private final String TAG = this.getClass().getName();
    private final WeatherDataSource weatherRepository;

    public GetWeatherForecast(WeatherDataSource weatherRepository) {
        this.weatherRepository = checkNotNull(weatherRepository, "weatherRepository cannot be null!");
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        weatherRepository.getWeatherForecastingData(requestValues.getCityId(),
                requestValues.getAppId(),
                new DataSourceCallBack<WeatherForecastResponse, ErrorResponse>() {
                    @Override
                    public void onSuccess(WeatherForecastResponse data) {
                        getUseCaseCallback().onSuccess(new ResponseValue(data));
                    }

                    @Override
                    public void onError(ErrorResponse error) {
                        getUseCaseCallback().onError(new ResponseValue(error));
                    }
                });
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private String cityId;
        private String appId;

        public RequestValues(String cityId, String appId) {
            this.cityId = cityId;
            this.appId = appId;
        }

        public String getCityId() {
            return cityId;
        }

        public String getAppId() {
            return appId;
        }
    }

    public class ResponseValue implements UseCase.ResponseValue {
        private WeatherForecastResponse data;
        private ErrorResponse error;


        public ResponseValue(WeatherForecastResponse data) {
            this.data = data;
        }

        public ResponseValue(ErrorResponse error) {
            this.error = error;
        }

        public WeatherForecastResponse getData() {
            return data;
        }

        public ErrorResponse getError() {
            return error;
        }
    }
}
