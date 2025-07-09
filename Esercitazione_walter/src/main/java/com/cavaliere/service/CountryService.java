package com.cavaliere.service;

import java.util.List;

import com.cavaliere.entities.Country;

public interface CountryService {

	List<Country> getCountries();
	Country getCountryById(String alpha2);
	Country getCountryByRand();
	
}
