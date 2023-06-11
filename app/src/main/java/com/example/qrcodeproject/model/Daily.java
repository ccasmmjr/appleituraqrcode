package com.example.qrcodeproject.model;

import java.util.ArrayList;

public class Daily {
    private ArrayList temperature_2m_max;
    private ArrayList temperature_2m_min;


    public ArrayList getTemperature_2m_max() {
        return temperature_2m_max;
    }
    public void setTemperatureMax(ArrayList temperature_2m_max){this.temperature_2m_max =temperature_2m_max ;}

    public ArrayList getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_max(ArrayList temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }
}
