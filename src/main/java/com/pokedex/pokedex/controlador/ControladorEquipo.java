package com.pokedex.pokedex.controlador;

import com.pokedex.pokedex.dominio.Equipo;
import com.pokedex.pokedex.servicio.EquipoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/equipos")
public class ControladorEquipo {

    private final EquipoServicio equipoServicio;

    @GetMapping
    public List<Equipo> mostrarEquipos() {
        return equipoServicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarPorId(@PathVariable Long id) {
        return equipoServicio.porId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipo añadirEquipo(@RequestBody Equipo equipo) {
        return equipoServicio.crear(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Long id,
                                                   @RequestBody Equipo equipo) {
        try {
            return ResponseEntity.ok(equipoServicio.actualizar(id, equipo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        equipoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}