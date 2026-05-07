package com.pokedex.pokedex.repositorio;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActoresRepositorio extends JpaRepository<Actor, Long> {

    // Buscar por nombre
    List<Actor> findByNombre(String nombre);

    // Buscar por nacionalidad
    List<Actor> findByNacionalidad(String nacionalidad);
}