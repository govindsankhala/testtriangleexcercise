package com.gss.weatherforecast;

public interface BaseView<T extends BasePresenter> {

    void showProgressDialog();

    void dismissProgressDialog();

}
