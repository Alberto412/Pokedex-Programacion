package com.pokedex.pokedex.Data;

import com.example.proyectointermodularprogramacionbasededatos.dominio.Actor;
import com.example.proyectointermodularprogramacionbasededatos.dominio.Director;
import com.example.proyectointermodularprogramacionbasededatos.dominio.Pelicula;
import com.example.proyectointermodularprogramacionbasededatos.repositorio.ActoresRepositorio;
import com.example.proyectointermodularprogramacionbasededatos.repositorio.DirectorRepositorio;
import com.example.proyectointermodularprogramacionbasededatos.repositorio.PeliculaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final PeliculaRepositorio peliculaRepositorio;
    private final ActoresRepositorio actoresRepositorio;
    private final DirectorRepositorio directorRepositorio;

    @Override
    public void run(String... args) {

        // ── PELÍCULAS ──────────────────────────────────────────────
        if (peliculaRepositorio.count() == 0) {
            peliculaRepositorio.saveAll(List.of(
                    new Pelicula(null, "El Padrino",              "Drama",      1972,""),
                    new Pelicula(null, "2001: Odisea en el Espacio", "Ciencia Ficción", 1968,""),
                    new Pelicula(null, "Blade Runner",            "Ciencia Ficción", 1982,""),
                    new Pelicula(null, "El Club de la Lucha",     "Drama",      1999,""),
                    new Pelicula(null, "Pulp Fiction",            "Crimen",     1994,""),
                    new Pelicula(null, "La Lista de Schindler",   "Historia",   1993,""),
                    new Pelicula(null, "Apocalypse Now",          "Bélica",     1979,""),
                    new Pelicula(null, "Metrópolis",              "Ciencia Ficción", 1927,""),
                    new Pelicula(null, "El Séptimo Sello",        "Drama",      1957,""),
                    new Pelicula(null, "Taxi Driver",             "Thriller",   1976,"")
            ));
            System.out.println("✅ 10 películas de culto cargadas.");
        }

        // ── ACTORES ───────────────────────────────────────────────
        if (actoresRepositorio.count() == 0) {
            actoresRepositorio.saveAll(List.of(
                    new Actor(null, "Marlon Brando",    "Estadounidense"),
                    new Actor(null, "Meryl Streep",     "Estadounidense"),
                    new Actor(null, "Al Pacino",        "Estadounidense"),
                    new Actor(null, "Cate Blanchett",   "Australiana"),
                    new Actor(null, "Robert De Niro",   "Estadounidense"),
                    new Actor(null, "Judi Dench",       "Británica"),
                    new Actor(null, "Jack Nicholson",   "Estadounidense"),
                    new Actor(null, "Sophia Loren",     "Italiana"),
                    new Actor(null, "Dustin Hoffman",   "Estadounidense"),
                    new Actor(null, "Katharine Hepburn","Estadounidense")
            ));
            System.out.println("✅ 10 actores legendarios cargados.");
        }

        // ── DIRECTORES ────────────────────────────────────────────
        if (directorRepositorio.count() == 0) {
            directorRepositorio.saveAll(List.of(
                    new Director(null, "Stanley Kubrick",    77),
                    new Director(null, "Francis Ford Coppola", 85),
                    new Director(null, "Steven Spielberg",   77),
                    new Director(null, "Akira Kurosawa",     88),
                    new Director(null, "Ingmar Bergman",     89),
                    new Director(null, "Federico Fellini",   73),
                    new Director(null, "Alfred Hitchcock",   80),
                    new Director(null, "Martin Scorsese",    81),
                    new Director(null, "Billy Wilder",       95),
                    new Director(null, "David Lynch",        78)
            ));
            System.out.println("✅ 10 directores premiados cargados.");
        }
    }
}