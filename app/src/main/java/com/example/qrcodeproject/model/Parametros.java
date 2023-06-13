package com.example.qrcodeproject.model;

public class Parametros {

    private String latitude;
    private String longitude;
    private String elevation;
    private String generationtime_ms;
    private String utc_offset_seconds;
    private String timezone;

    private Daily daily;

     public String getLatitude(){
        return latitude;
    }
    public void setLatitude(String latitude){
        this.latitude = String.valueOf(latitude);
    }

    public String getlongitude(){
        return longitude;
    }
    public void setlongitude(float longitude){
        this.longitude = String.valueOf(longitude);
    }

    public String getelevation(){
        return elevation;
    }
    public void setelevation(float elevation){
       this.elevation = String.valueOf(elevation);
    }

    public String getgenerationtime_ms(){
        return generationtime_ms;
    }
    public void setgenerationtime_ms(float generationtime_ms){
        this.generationtime_ms = String.valueOf(generationtime_ms);
    }

    public String getutc_offset_seconds(){
        return utc_offset_seconds;
    }
    public void setutc_offset_seconds(int utc_offset_seconds){
        this.utc_offset_seconds = String.valueOf(utc_offset_seconds);
    }

    public String gettimezone(){
        return timezone;
    }
    public void settimezone(String timezone){
        this.timezone = String.valueOf(timezone);
    }

    public void setDaily(Daily daily){this.daily=daily;}
    public String getTemperatureMax(){return daily.getTemperature_2m_max().toString();}
    public String getTemperatureMin(){return daily.getTemperature_2m_min().toString();}

}
