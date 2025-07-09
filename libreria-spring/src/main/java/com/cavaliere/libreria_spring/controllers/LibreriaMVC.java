package com.cavaliere.libreria_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cavaliere.libreria_spring.entities.Libro;
import com.cavaliere.libreria_spring.services.LibreriaService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LibreriaMVC {

    @Autowired
    private LibreriaService service;

    @GetMapping("")
    public String getHome(Model m) {
        m.addAttribute("titolo", "Benvenuto nella libreria");
        return "index";
    }

    @GetMapping("libri")
    public String getLibri(Model m) {
        m.addAttribute("titolo", "i piu grandi libri di sempre");
        m.addAttribute("generi", service.getGeneri());
        m.addAttribute("libri", service.getLibri());
        return "vista_libri";
    }

    @PostMapping("libri")
    public String addLibro(@RequestBody Libro l) {
        
        service.addLibro(l);

        return "vista_libri";
    }
    
    

}
