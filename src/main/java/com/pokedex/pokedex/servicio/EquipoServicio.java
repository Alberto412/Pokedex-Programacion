package com.pokedex.pokedex.servicio;

import com.pokedex.pokedex.dominio.Equipo;
import com.pokedex.pokedex.repositorio.EquipoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EquipoServicio {

    private final EquipoRepositorio repositorio;

    public EquipoServicio(EquipoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Equipo crear(Equipo e) {
        return repositorio.save(e);
    }

    public List<Equipo> listar() {
        return repositorio.findAll();
    }

    public Optional<Equipo> porId(Long id) {
        return repositorio.findById(id);
    }

    public Equipo actualizar(Long id, Equipo datos) {
        Equipo e = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        e.setNombre(datos.getNombre());

        return repositorio.save(e);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}