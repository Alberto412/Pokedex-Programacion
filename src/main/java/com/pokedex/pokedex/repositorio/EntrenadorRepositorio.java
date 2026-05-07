package com.pokedex.pokedex.repositorio;

import com.pokedex.pokedex.dominio.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {

    List<Entrenador> findByNombre(String nombre);
}