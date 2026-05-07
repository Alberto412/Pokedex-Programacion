package com.pokedex.pokedex.controlador;

import com.pokedex.pokedex.dominio.Pokemon;
import com.pokedex.pokedex.servicio.PokemonServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pokemon")
public class ControladorPokemon {

    private final PokemonServicio pokemonServicio;

    @GetMapping
    public List<Pokemon> mostrarPokemon() {
        return pokemonServicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> buscarPorId(@PathVariable Long id) {
        return pokemonServicio.porId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pokemon añadirPokemon(@RequestBody Pokemon pokemon) {
        return pokemonServicio.crear(pokemon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> actualizarPokemon(@PathVariable Long id,
                                                     @RequestBody Pokemon pokemon) {
        try {
            return ResponseEntity.ok(pokemonServicio.actualizar(id, pokemon));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPokemon(@PathVariable Long id) {
        pokemonServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}