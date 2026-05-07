package com.pokedex.pokedex.controlador;

import com.pokedex.pokedex.dominio.Entrenador;
import com.pokedex.pokedex.servicio.EntrenadorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entrenadores")
public class ControladorEntrenador {

    private final EntrenadorServicio entrenadorServicio;

    @GetMapping
    public List<Entrenador> mostrarEntrenadores() {
        return entrenadorServicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> buscarPorId(@PathVariable Long id) {
        return entrenadorServicio.porId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador añadirEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorServicio.crear(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizarEntrenador(@PathVariable Long id,
                                                           @RequestBody Entrenador entrenador) {
        try {
            return ResponseEntity.ok(entrenadorServicio.actualizar(id, entrenador));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEntrenador(@PathVariable Long id) {
        entrenadorServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}