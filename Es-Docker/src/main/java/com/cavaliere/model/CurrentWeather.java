package com.cavaliere.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeather {
    private String time;
    
    @JsonProperty("temperature_2m")
    private Double temperature_2m;
    
    // Costruttori
    public CurrentWeather() {}
    
    public CurrentWeather(String time, Double temperature_2m) {
        this.time = time;
        this.temperature_2m = temperature_2m;
    }
    
    // Getter e Setter
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public Double getTemperature_2m() {
        return temperature_2m;
    }
    
    public void setTemperature_2m(Double temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
}
