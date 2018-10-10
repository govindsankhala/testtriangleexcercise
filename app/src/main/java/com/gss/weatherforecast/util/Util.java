package com.gss.weatherforecast.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String convertTimeStampToDateTime(String timeStamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy\nHH : mm : ss");
        String dateTime = "";
        try {
            Timestamp timestamp = new Timestamp(Long.parseLong(timeStamp)*1000);
            Date date = new Date(timestamp.getTime());
            dateTime = simpleDateFormat.format(date);
        } catch (NumberFormatException e) {
        }

        return dateTime;
    }
}
