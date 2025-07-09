package com.cavaliere.libreria_spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavaliere.libreria_spring.entities.Libro;
import com.cavaliere.libreria_spring.repos.LibriDAO;

@Service
public class LibreriaService {

    @Autowired
    private LibriDAO dao;

    public List<String> getGeneri() {
        
        return List.of("Fantascienza", "Horror", "Fantasy", "Romanzo", "Giallo", "Avventura");
    }

    public List<Libro> getLibri() {
        
      return dao.findAll();
                
    }

    public void addLibro(Libro l) {
        dao.save(l);
    }

}
