package com.cavaliere.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cavaliere.model.WeatherResponse;

import reactor.core.publisher.Mono;

@Service
public class WeatherService {
    
    private final WebClient webClient;
    
    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.open-meteo.com/v1").build();
    }
    
    public Mono<WeatherResponse> getWeatherData(double latitude, double longitude) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(14);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam("current", "temperature_2m")
                        .queryParam("daily", "temperature_2m_max,temperature_2m_min,temperature_2m_mean")
                        .queryParam("start_date", startDate.format(formatter))
                        .queryParam("end_date", endDate.format(formatter))
                        .queryParam("timezone", "auto")
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class);
    }
}
