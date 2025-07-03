package com.paulapc.quipux_skills.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaReproduccion {

    @Id
    private String nombre;
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> canciones;
}
