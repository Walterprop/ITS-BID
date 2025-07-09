package com.cavaliere.model;

import java.time.LocalDate;
import java.util.List;

public class WeatherData {
    private List<LocalDate> time;
    private List<Double> temperature_2m_max;
    private List<Double> temperature_2m_min;
    private List<Double> temperature_2m_mean;
    
    // Costruttori
    public WeatherData() {}
    
    public WeatherData(List<LocalDate> time, List<Double> temperature_2m_max, 
                      List<Double> temperature_2m_min, List<Double> temperature_2m_mean) {
        this.time = time;
        this.temperature_2m_max = temperature_2m_max;
        this.temperature_2m_min = temperature_2m_min;
        this.temperature_2m_mean = temperature_2m_mean;
    }
    
    // Getter e Setter
    public List<LocalDate> getTime() {
        return time;
    }
    
    public void setTime(List<LocalDate> time) {
        this.time = time;
    }
    
    public List<Double> getTemperature_2m_max() {
        return temperature_2m_max;
    }
    
    public void setTemperature_2m_max(List<Double> temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }
    
    public List<Double> getTemperature_2m_min() {
        return temperature_2m_min;
    }
    
    public void setTemperature_2m_min(List<Double> temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }
    
    public List<Double> getTemperature_2m_mean() {
        return temperature_2m_mean;
    }
    
    public void setTemperature_2m_mean(List<Double> temperature_2m_mean) {
        this.temperature_2m_mean = temperature_2m_mean;
    }
}
