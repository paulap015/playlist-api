package com.paulapc.quipux_skills.business;


import com.paulapc.quipux_skills.model.ListaReproduccion;
import com.paulapc.quipux_skills.repository.ListaReproduccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaReproduccionImpl implements IListaReproduccionBusiness{
    private final ListaReproduccionRepository repo;

    @Override
    public ListaReproduccion crearLista(ListaReproduccion lista) {
        return repo.save(lista);
    }

    @Override
    public List<ListaReproduccion> listarListas() {
        return repo.findAll();
    }

    @Override
    public Optional<ListaReproduccion> obtenerLista(String nombre) {
        return repo.findById(nombre);
    }

    @Override
    public boolean eliminarLista(String nombre) {
        return repo.findById(nombre).map(lista -> {
            repo.delete(lista);
            return true;
        }).orElse(false);
    }
}
