package com.pokedex.pokedex.controlador;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Actor;
import com.example.proyectointermodularprogramacionbasededatos.servicio.ActorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actores")
public class ControladorActor {

    private final ActorServicio actorServicio;

    @GetMapping
    public List<Actor> mostrarActores() {
        return actorServicio.mostrarActores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> buscarPorId(@PathVariable Long id) {
        return actorServicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Actor añadirActor(@RequestBody Actor actor) {
        return actorServicio.añadirActor(actor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> actualizarActor(@PathVariable Long id, @RequestBody Actor actor) {
        return actorServicio.actualizarActor(id, actor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarActor(@PathVariable Long id) {
        return actorServicio.eliminarActor(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}