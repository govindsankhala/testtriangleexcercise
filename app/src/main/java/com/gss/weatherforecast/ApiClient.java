package com.gss.weatherforecast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gss.weatherforecast.retrofit.ItemTypeAdapterFactory;
import com.gss.weatherforecast.retrofit.RxErrorHandlingCallAdapterFactory;
import com.gss.weatherforecast.util.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final Gson gson;

    private static final HttpLoggingInterceptor interceptor;

    private static final OkHttpClient client;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }
}