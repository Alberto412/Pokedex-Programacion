package com.pokedex.pokedex.controlador;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Pelicula;
import com.example.proyectointermodularprogramacionbasededatos.servicio.PeliculaServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/peliculas")
public class ControladorPelicula {

    private final PeliculaServicio peliculaServicio;

    @GetMapping
    public List<Pelicula> mostrarPeliculas() {
        return peliculaServicio.mostrarPeliculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
        return peliculaServicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pelicula añadirPelicula(@Valid @RequestBody Pelicula pelicula) {
        return peliculaServicio.añadirPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@Valid @PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaServicio.actualizarPelicula(id, pelicula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
        return peliculaServicio.eliminarPelicula(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}