package com.pokedex.pokedex.repositorio;

import com.pokedex.pokedex.dominio.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepositorio extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findByNombre(String nombre);

    List<Pokemon> findByTipo(String tipo);
}