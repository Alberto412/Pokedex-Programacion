package com.pokedex.pokedex.repositorio;

import com.pokedex.pokedex.dominio.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {

    List<Equipo> findByNombre(String nombre);
}