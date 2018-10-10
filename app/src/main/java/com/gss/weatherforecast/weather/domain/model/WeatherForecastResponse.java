package com.gss.weatherforecast.weather.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecastResponse {

    @SerializedName("cod")
    private String status;

    @SerializedName("list")
    private List<Data> list;

    public String getStatus() {
        return status;
    }

    public List<Data> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "WeatherForecastResponse{" +
                "status='" + status + '\'' +
                ", list=" + list +
                '}';
    }

    public static class Data {
        @SerializedName("dt")
        private String timeStamp;

        @SerializedName("main")
        private Main main;

        @SerializedName("weather")
        private List<Weather> weather;

        @SerializedName("clouds")
        private Clouds clouds;

        @SerializedName("wind")
        private Wind wind;

        public String getTimeStamp() {
            return timeStamp;
        }

        public Main getMain() {
            return main;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public Wind getWind() {
            return wind;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "timeStamp='" + timeStamp + '\'' +
                    ", main=" + main +
                    ", weather=" + weather +
                    ", clouds=" + clouds +
                    ", wind=" + wind +
                    '}';
        }
    }

    public static class Main {

        @SerializedName("temp")
        private String temperature;

        @SerializedName("temp_min")
        private String minimumTemperature;

        @SerializedName("temp_max")
        private String maximumTemperature;

        @SerializedName("pressure")
        private String pressure;

        @SerializedName("sea_level")
        private String seaLevel;

        @SerializedName("humidity")
        private String humidity;

        public String getTemperature() {
            return temperature;
        }

        public String getMinimumTemperature() {
            return minimumTemperature;
        }

        public String getMaximumTemperature() {
            return maximumTemperature;
        }

        public String getPressure() {
            return pressure;
        }

        public String getSeaLevel() {
            return seaLevel;
        }

        public String getHumidity() {
            return humidity;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "temperature='" + temperature + '\'' +
                    ", minimumTemperature='" + minimumTemperature + '\'' +
                    ", maximumTemperature='" + maximumTemperature + '\'' +
                    ", pressure='" + pressure + '\'' +
                    ", seaLevel='" + seaLevel + '\'' +
                    ", humidity='" + humidity + '\'' +
                    '}';
        }
    }

    public static class Weather {

        @SerializedName("main")
        private String main;

        @SerializedName("description")
        private String description;

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "main='" + main + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    public static class Clouds {
        @SerializedName("all")
        private int all;

        public int getAll() {
            return all;
        }

        @Override
        public String toString() {
            return "Clouds{" +
                    "all=" + all +
                    '}';
        }
    }

    public static class Wind {

        @SerializedName("speed")
        private String speed;

        @SerializedName("deg")
        private String angle;

        public String getSpeed() {
            return speed;
        }

        public String getAngle() {
            return angle;
        }

        @Override
        public String toString() {
            return "Wind{" +
                    "speed='" + speed + '\'' +
                    ", angle='" + angle + '\'' +
                    '}';
        }
    }
}
