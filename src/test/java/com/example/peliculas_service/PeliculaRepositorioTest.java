package com.example.peliculas_service;

import com.example.peliculas_service.model.Pelicula;
import com.example.peliculas_service.repositorios.PeliculaRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 👈 Esta línea es CLAVE
class PeliculaRepositorioTest {

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    @Test
    void guardarYBuscarPelicula() {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(1L);
        pelicula.setTitulo("Inception");
        pelicula.setAnio(2010);
        pelicula.setDirector("Christopher Nolan");
        pelicula.setGenero("Ciencia Ficción");
        pelicula.setSinopsis("Sueños dentro de sueños.");

        peliculaRepositorio.save(pelicula);

        // Aquí puedes agregar un assert para validar que se guardó correctamente
    }
}
