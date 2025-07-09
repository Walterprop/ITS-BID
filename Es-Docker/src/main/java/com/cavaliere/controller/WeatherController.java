package com.cavaliere.controller;

import com.cavaliere.model.City;
import com.cavaliere.model.WeatherResponse;
import com.cavaliere.service.CityService;
import com.cavaliere.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class WeatherController {
    
    @Autowired
    private CityService cityService;
    
    @Autowired
    private WeatherService weatherService;
    
    @GetMapping("/")
    public String index(Model model) {
        List<City> cities = cityService.getAllCities();
        model.addAttribute("cities", cities);
        return "index";
    }
    
    @PostMapping("/weather")
    public String getWeather(@RequestParam("cityId") Long cityId, Model model) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            try {
                WeatherResponse weatherResponse = weatherService.getWeatherData(
                    city.getLatitude(), city.getLongitude()).block();
                
                model.addAttribute("city", city);
                model.addAttribute("weatherData", weatherResponse);
                return "weather";
            } catch (Exception e) {
                model.addAttribute("error", "Errore nel recupero dei dati meteorologici: " + e.getMessage());
                return "error";
            }
        } else {
            model.addAttribute("error", "Città non trovata");
            return "error";
        }
    }
    
    @GetMapping("/api/weather/{cityId}")
    @ResponseBody
    public Mono<WeatherResponse> getWeatherApi(@PathVariable Long cityId) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            return weatherService.getWeatherData(city.getLatitude(), city.getLongitude());
        }
        return Mono.empty();
    }
}
