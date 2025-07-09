package com.cavaliere.repos;

import com.cavaliere.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, String> {
    Country findByName(String name);
}