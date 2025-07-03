package com.paulapc.quipux_skills.business;

import com.paulapc.quipux_skills.model.ListaReproduccion;

import java.util.List;
import java.util.Optional;

public interface IListaReproduccionBusiness {

    ListaReproduccion crearLista(ListaReproduccion lista);

    List<ListaReproduccion> listarListas();

    Optional<ListaReproduccion> obtenerLista(String nombre);

    boolean eliminarLista(String nombre);
}
