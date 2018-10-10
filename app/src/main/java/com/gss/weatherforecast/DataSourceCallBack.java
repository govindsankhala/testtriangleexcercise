package com.gss.weatherforecast;

public interface DataSourceCallBack<T,V> {
        void onSuccess(T data);
        void onError(V error);
}
