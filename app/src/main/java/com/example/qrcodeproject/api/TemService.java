package com.example.qrcodeproject.api;

import com.example.qrcodeproject.model.Parametros;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

import retrofit2.http.Query;


public interface TemService {

// Rota API
    //@GET("forecast?latitude=52.52&longitude=13.41&daily=temperature_2m_max,temperature_2m_min&timeformat=unixtime&forecast_days=1&timezone=auto")
    @GET("forecast")
    Call<Parametros> Forecast(@Query("latitude")String latitude, @Query("longitude")String longitude,
                              @Query("daily")String daily, @Query("timeformat")String timeformat,
                              @Query("forecast_days")String forecast_days, @Query("timezone")String timezone);
}
