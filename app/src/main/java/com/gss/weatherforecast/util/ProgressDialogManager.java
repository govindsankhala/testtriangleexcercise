package com.gss.weatherforecast.util;

import android.app.ProgressDialog;
import android.content.Context;


/**
 * Common ProgressDialog class for the application
 */
public class ProgressDialogManager {
    private static ProgressDialog mProgressDialog;

    public static void showProgressDialog(Context context, String message, boolean isCancellableOnOutsideTouch) {
        dismissProgressDialog();
        mProgressDialog = new ProgressDialog(context);
        if (message != null && !message.isEmpty())
            mProgressDialog.setMessage(message);
        else
            mProgressDialog.setMessage("loading...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public static void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
