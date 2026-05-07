package com.pokedex.pokedex.Data;

import com.pokedex.pokedex.dominio.Equipo;
import com.pokedex.pokedex.dominio.Entrenador;
import com.pokedex.pokedex.dominio.Pokemon;
import com.pokedex.pokedex.repositorio.EquipoRepositorio;
import com.pokedex.pokedex.repositorio.EntrenadorRepositorio;
import com.pokedex.pokedex.repositorio.PokemonRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final PokemonRepositorio pokemonRepositorio;
    private final EntrenadorRepositorio entrenadorRepositorio;
    private final EquipoRepositorio equipoRepositorio;

    @Override
    public void run(String... args) {

        if (pokemonRepositorio.count() == 0) {
            pokemonRepositorio.saveAll(List.of(
                    new Pokemon(null, "Pikachu", "Eléctrico", "Kanto"),
                    new Pokemon(null, "Charmander", "Fuego", "Kanto"),
                    new Pokemon(null, "Bulbasaur", "Planta", "Kanto"),
                    new Pokemon(null, "Squirtle", "Agua", "Kanto"),
                    new Pokemon(null, "Eevee", "Normal", "Kanto"),
                    new Pokemon(null, "Gengar", "Fantasma", "Kanto"),
                    new Pokemon(null, "Dragonite", "Dragón", "Kanto"),
                    new Pokemon(null, "Lucario", "Lucha", "Sinnoh"),
                    new Pokemon(null, "Greninja", "Agua", "Kalos"),
                    new Pokemon(null, "Mewtwo", "Psíquico", "Kanto")
            ));
        }

        if (equipoRepositorio.count() == 0) {

            List<Pokemon> pokemons = pokemonRepositorio.findAll();

            Equipo equipo1 = new Equipo();
            equipo1.setNombre("Equipo Rojo");
            equipo1.setNivel(50);
            equipo1.setPokemons(new ArrayList<>(List.of(pokemons.get(0), pokemons.get(1))));

            Equipo equipo2 = new Equipo();
            equipo2.setNombre("Equipo Azul");
            equipo2.setNivel(60);
            equipo2.setPokemons(new ArrayList<>(List.of(pokemons.get(2), pokemons.get(3))));

            Equipo equipo3 = new Equipo();
            equipo3.setNombre("Equipo Verde");
            equipo3.setNivel(70);
            equipo3.setPokemons(new ArrayList<>(List.of(pokemons.get(4), pokemons.get(5))));

            Equipo equipo4 = new Equipo();
            equipo4.setNombre("Equipo Amarillo");
            equipo4.setNivel(80);
            equipo4.setPokemons(new ArrayList<>(List.of(pokemons.get(6), pokemons.get(7))));

            Equipo equipo5 = new Equipo();
            equipo5.setNombre("Equipo Negro");
            equipo5.setNivel(90);
            equipo5.setPokemons(new ArrayList<>(List.of(pokemons.get(8), pokemons.get(9))));

            equipoRepositorio.saveAll(List.of(equipo1, equipo2, equipo3, equipo4, equipo5));
        }

        if (entrenadorRepositorio.count() == 0) {

            List<Equipo> equipos = equipoRepositorio.findAll();

            entrenadorRepositorio.saveAll(List.of(
                    new Entrenador(null, "Ash Ketchum", 10, equipos.get(0)),
                    new Entrenador(null, "Misty", 12, equipos.get(1)),
                    new Entrenador(null, "Brock", 15, equipos.get(2)),
                    new Entrenador(null, "Gary Oak", 11, equipos.get(3)),
                    new Entrenador(null, "Red", 16, equipos.get(4))
            ));
        }
    }
}