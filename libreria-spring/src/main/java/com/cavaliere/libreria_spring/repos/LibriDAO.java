package com.cavaliere.libreria_spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cavaliere.libreria_spring.entities.Libro;

public interface LibriDAO extends JpaRepository<Libro, Integer> {
    
    
}
