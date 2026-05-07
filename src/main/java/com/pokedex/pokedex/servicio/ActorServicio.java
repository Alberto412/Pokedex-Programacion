package com.pokedex.pokedex.servicio;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Actor;
import com.example.proyectointermodularprogramacionbasededatos.repositorio.ActoresRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ActorServicio {

    private final ActoresRepositorio repositorio;

    public List<Actor> mostrarActores() {
        return repositorio.findAll();
    }

    public Optional<Actor> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    public Actor añadirActor(Actor actor) {
        return repositorio.save(actor);
    }

    public Optional<Actor> actualizarActor(Long id, Actor actorActualizado) {
        return repositorio.findById(id).map(actor -> {
            actor.setNombre(actorActualizado.getNombre());
            actor.setNacionalidad(actorActualizado.getNacionalidad());
            return repositorio.save(actor);
        });
    }

    public boolean eliminarActor(Long id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }
}