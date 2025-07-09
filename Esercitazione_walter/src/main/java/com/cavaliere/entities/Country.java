package com.cavaliere.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "countries")
public class Country {
	
	@Id
    private String alpha2code;
    private String alpha3code;  // AGGIUNGI questo
    private String capital;
    private String name;
    private String region;
    private String population;  // AGGIUNGI questo
    private String area;        // AGGIUNGI questo
	private String languages;
	
	
	@Transient
	private String flag;
	
	
	public String getAlpha2Code() {
		return alpha2code;
	}
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2code = alpha2Code;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getFlag() {
		return "/flags/" + this.alpha2code.toLowerCase() + ".png";
	}

	public String getAlpha3code() { return alpha3code; }
    public void setAlpha3code(String alpha3code) { this.alpha3code = alpha3code; }
    public String getPopulation() { return population; }
    public void setPopulation(String population) { this.population = population; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
	public String getLanguages() { return languages; }
    public void setLanguages(String languages) { this.languages = languages; }
	
}
