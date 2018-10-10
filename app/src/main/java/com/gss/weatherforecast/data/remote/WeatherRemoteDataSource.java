package com.gss.weatherforecast.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.gss.weatherforecast.ApiClient;
import com.gss.weatherforecast.DataSourceCallBack;
import com.gss.weatherforecast.ErrorResponse;
import com.gss.weatherforecast.data.WeatherApi;
import com.gss.weatherforecast.data.WeatherDataSource;
import com.gss.weatherforecast.retrofit.RetrofitException;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WeatherRemoteDataSource implements WeatherDataSource {

    @SuppressWarnings("unused")
    private final String TAG = this.getClass().getName();
    private static WeatherRemoteDataSource instance;
    @SuppressWarnings("unused")
    private Context context;

    private WeatherRemoteDataSource(@NonNull Context context) {
        this.context = context;
    }

    public static WeatherRemoteDataSource getInstance(@NonNull Context context) {
        if (instance == null) {
            instance = new WeatherRemoteDataSource(context);
        }
        return instance;
    }

    @Override
    public void getWeatherForecastingData(String cityId, String appId, final DataSourceCallBack<WeatherForecastResponse, ErrorResponse> dataSourceCallBack) {
        Log.i(TAG, "getWeatherForecastingData : " + cityId + " " + appId);

        WeatherApi weatherApi = ApiClient.getClient().create(WeatherApi.class);

        Observable<WeatherForecastResponse> weatherForecastResponseObservable = weatherApi.getWeatherForecastData(cityId, appId);
        weatherForecastResponseObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherForecastResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        RetrofitException error = (RetrofitException) e;
                        ErrorResponse errorResponse = error.getServerResponse();
                        Log.i(TAG, "onError : " + errorResponse);
                        dataSourceCallBack.onError(errorResponse);
                    }

                    @Override
                    public void onNext(WeatherForecastResponse data) {
                        Log.i(TAG, "onNext : " + data);
                        dataSourceCallBack.onSuccess(data);
                    }
                });
    }
}
