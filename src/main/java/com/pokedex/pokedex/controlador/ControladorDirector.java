package com.pokedex.pokedex.controlador;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Director;
import com.example.proyectointermodularprogramacionbasededatos.servicio.DirectorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/directores")
public class ControladorDirector {

    private final DirectorServicio directorServicio;

    @GetMapping
    public List<Director> mostrarDirectores() {
        return directorServicio.mostrarDirectores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> buscarPorId(@PathVariable Long id) {
        return directorServicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Director añadirDirector(@RequestBody Director director) {
        return directorServicio.añadirDirector(director);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> actualizarDirector(@PathVariable Long id, @RequestBody Director director) {
        return directorServicio.actualizarDirector(id, director)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDirector(@PathVariable Long id) {
        return directorServicio.eliminarDirector(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}