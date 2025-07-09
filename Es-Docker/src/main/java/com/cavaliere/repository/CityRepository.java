package com.cavaliere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cavaliere.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
