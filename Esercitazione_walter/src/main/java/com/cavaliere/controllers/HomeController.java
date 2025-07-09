package com.cavaliere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cavaliere.service.CountryService;

@Controller
public class HomeController {

    @Autowired
    private CountryService countryService;


    @GetMapping("/")
    public String home() {
        return "home";
    }

    
    @GetMapping("/allenamento")
    public String allenamento(Model model) {
        model.addAttribute("paesi", countryService.getCountries());
        return "allenamento";
    }

    
    @GetMapping("/modalita")
    public String scegliDifficolta() {
        return "modalita";
    }

}