package com.pokedex.pokedex.servicio;

import com.pokedex.pokedex.dominio.Pokemon;
import com.pokedex.pokedex.repositorio.PokemonRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonServicio {

    private final PokemonRepositorio repositorio;

    public PokemonServicio(PokemonRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Pokemon crear(Pokemon p) {
        return repositorio.save(p);
    }

    public List<Pokemon> listar() {
        return repositorio.findAll();
    }

    public Optional<Pokemon> porId(Long id) {
        return repositorio.findById(id);
    }

    public Pokemon actualizar(Long id, Pokemon datos) {

        Pokemon p = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon no encontrado"));

        p.setNombre(datos.getNombre());
        p.setTipo(datos.getTipo());
        p.setRegion(datos.getRegion()); // ✅ ESTA ES LA CORRECTA EN TU MODELO

        return repositorio.save(p);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}