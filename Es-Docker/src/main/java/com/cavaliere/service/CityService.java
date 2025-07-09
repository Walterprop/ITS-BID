package com.cavaliere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavaliere.model.City;
import com.cavaliere.repository.CityRepository;

import jakarta.annotation.PostConstruct;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;
    
    @PostConstruct
    public void initializeCities() {
        if (cityRepository.count() == 0) {
            // Aggiungiamo alcune città italiane con le loro coordinate
            cityRepository.save(new City("Roma", 41.9028, 12.4964));
            cityRepository.save(new City("Milano", 45.4642, 9.1900));
            cityRepository.save(new City("Napoli", 40.8518, 14.2681));
            cityRepository.save(new City("Torino", 45.0703, 7.6869));
            cityRepository.save(new City("Palermo", 38.1157, 13.3613));
            cityRepository.save(new City("Genova", 44.4056, 8.9463));
            cityRepository.save(new City("Bologna", 44.4949, 11.3426));
            cityRepository.save(new City("Firenze", 43.7696, 11.2558));
            cityRepository.save(new City("Bari", 41.1171, 16.8719));
            cityRepository.save(new City("Catania", 37.5079, 15.0830));
        }
    }
    
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }
}
