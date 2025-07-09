package com.cavaliere.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    private Double latitude;
    private Double longitude;
    private String timezone;
    
    @JsonProperty("current")
    private CurrentWeather current;
    
    @JsonProperty("daily")
    private WeatherData daily;
    
    // Costruttori
    public WeatherResponse() {}
    
    public WeatherResponse(Double latitude, Double longitude, String timezone, CurrentWeather current, WeatherData daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
        this.current = current;
        this.daily = daily;
    }
    
    // Getter e Setter
    public Double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    public Double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public String getTimezone() {
        return timezone;
    }
    
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
    public WeatherData getDaily() {
        return daily;
    }
    
    public void setDaily(WeatherData daily) {
        this.daily = daily;
    }
    
    public CurrentWeather getCurrent() {
        return current;
    }
    
    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }
}
