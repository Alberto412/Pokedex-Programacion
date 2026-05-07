package com.pokedex.pokedex.servicio;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Pelicula;
import com.example.proyectointermodularprogramacionbasededatos.repositorio.PeliculaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PeliculaServicio {

    private final PeliculaRepositorio repositorio;

    public List<Pelicula> mostrarPeliculas() {
        return repositorio.findAll();
    }

    public Optional<Pelicula> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    public Pelicula añadirPelicula(Pelicula pelicula) {
        return repositorio.save(pelicula);
    }

    public Optional<Pelicula> actualizarPelicula(Long id, Pelicula peliculaActualizada) {
        return repositorio.findById(id).map(pelicula -> {
            pelicula.setTitulo(peliculaActualizada.getTitulo());
            pelicula.setGenero(peliculaActualizada.getGenero());
            pelicula.setAnho(peliculaActualizada.getAnho());
            return repositorio.save(pelicula);
        });
    }

    public boolean eliminarPelicula(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }
}