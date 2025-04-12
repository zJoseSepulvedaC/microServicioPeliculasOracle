package com.example.peliculas_service.controller;

import com.example.peliculas_service.model.Pelicula;
import com.example.peliculas_service.repositorios.PeliculaRepositorio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaRepositorio peliculaRepositorio;

    public PeliculaController(PeliculaRepositorio peliculaRepositorio) {
        this.peliculaRepositorio = peliculaRepositorio;
    }

    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return peliculaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPorId(@PathVariable Long id) {
        return peliculaRepositorio.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula nuevaPelicula) {
    if (peliculaRepositorio.existsById(nuevaPelicula.getId())) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Mensaje si es que ya existe.
    }
    Pelicula guardada = peliculaRepositorio.save(nuevaPelicula);
    return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }

    
}
