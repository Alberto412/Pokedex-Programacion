package com.pokedex.pokedex.servicio;

import com.pokedex.pokedex.dominio.Entrenador;
import com.pokedex.pokedex.repositorio.EntrenadorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorServicio {

    private final EntrenadorRepositorio repositorio;

    public EntrenadorServicio(EntrenadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Entrenador crear(Entrenador e) {
        return repositorio.save(e);
    }

    public List<Entrenador> listar() {
        return repositorio.findAll();
    }

    public Optional<Entrenador> porId(Long id) {
        return repositorio.findById(id);
    }

    public Entrenador actualizar(Long id, Entrenador datos) {

        Entrenador e = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        e.setNombre(datos.getNombre());
        e.setEdad(datos.getEdad()); // ✅ correcto en tu modelo
        e.setEquipo(datos.getEquipo()); // ✅ relación OneToOne

        return repositorio.save(e);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}