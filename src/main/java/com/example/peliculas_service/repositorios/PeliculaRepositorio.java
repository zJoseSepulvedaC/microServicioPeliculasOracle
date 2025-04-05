package com.example.peliculas_service.repositorios;

import com.example.peliculas_service.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {
}
