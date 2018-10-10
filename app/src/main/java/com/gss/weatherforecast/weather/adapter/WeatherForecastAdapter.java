package com.gss.weatherforecast.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gss.weatherforecast.R;
import com.gss.weatherforecast.util.Util;
import com.gss.weatherforecast.weather.domain.model.WeatherForecastResponse;

import java.text.SimpleDateFormat;
import java.util.List;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.ViewHolder> {

    private Context mContext;
    private List<WeatherForecastResponse.Data> mDataList;


    public WeatherForecastAdapter(Context context, List<WeatherForecastResponse.Data> dataList) {
        mDataList = dataList;
        mContext = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather_forecast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final WeatherForecastResponse.Data data = mDataList.get(position);

        holder.tvDateTime.setText(Util.convertTimeStampToDateTime(data.getTimeStamp()));
        holder.tvTemperature.setText(mContext.getString(R.string.temp_min_max, data.getMain().getTemperature(), data.getMain().getMinimumTemperature(),
                data.getMain().getMaximumTemperature()));
        holder.tvHumidity.setText(data.getMain().getHumidity());
        holder.tvWind.setText(mContext.getString(R.string.wind_speed_angle, data.getWind().getSpeed(), data.getWind().getAngle()));
        holder.tvWeather.setText("");
        if (data.getWeather().size() > 0) {
            WeatherForecastResponse.Weather weather = data.getWeather().get(0);
            holder.tvWeather.setText(mContext.getString(R.string.weather_main_description, weather.getMain(), weather.getDescription()));
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDateTime;
        private TextView tvTemperature;
        private TextView tvHumidity;
        private TextView tvWeather;
        private TextView tvWind;

        ViewHolder(View view) {
            super(view);
            tvDateTime = view.findViewById(R.id.tvDateTime);
            tvTemperature = view.findViewById(R.id.tvTemperature);
            tvHumidity = view.findViewById(R.id.tvHumidity);
            tvWeather = view.findViewById(R.id.tvWeather);
            tvWind = view.findViewById(R.id.tvWind);
        }
    }
}
