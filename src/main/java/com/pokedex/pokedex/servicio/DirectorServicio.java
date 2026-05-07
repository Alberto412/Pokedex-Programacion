package com.pokedex.pokedex.servicio;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Director;
import com.example.proyectointermodularprogramacionbasededatos.repositorio.DirectorRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DirectorServicio {

    private final DirectorRepositorio repositorio;

    public List<Director> mostrarDirectores() {
        return repositorio.findAll();
    }

    public Optional<Director> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    public Director añadirDirector(Director director) {
        return repositorio.save(director);
    }

    public Optional<Director> actualizarDirector(Long id, Director directorActualizado) {
        return repositorio.findById(id).map(director -> {
            director.setNombre(directorActualizado.getNombre());
            director.setEdad(directorActualizado.getEdad());
            return repositorio.save(director);
        });
    }

    public boolean eliminarDirector(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }
}