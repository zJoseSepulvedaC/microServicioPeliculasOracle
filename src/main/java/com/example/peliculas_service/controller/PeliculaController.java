package com.example.peliculas_service.controller;

import com.example.peliculas_service.model.Pelicula;
import com.example.peliculas_service.repositorios.PeliculaRepositorio;
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
}
