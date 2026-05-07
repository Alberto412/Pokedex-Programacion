package com.pokedex.pokedex.repositorio;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepositorio extends JpaRepository<Director, Long> {

    // Buscar por nombre
    List<Director> findByNombre(String nombre);

    // Buscar por edad (asumiendo que ese int es edad)
    List<Director> findByEdad(int edad);
}