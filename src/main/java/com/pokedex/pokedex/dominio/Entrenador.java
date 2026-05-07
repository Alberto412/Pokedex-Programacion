package com.pokedex.pokedex.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    private Equipo equipo;
}