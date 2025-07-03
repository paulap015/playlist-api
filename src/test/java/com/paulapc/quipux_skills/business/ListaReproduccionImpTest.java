package com.paulapc.quipux_skills.business;

import com.paulapc.quipux_skills.model.ListaReproduccion;
import com.paulapc.quipux_skills.repository.ListaReproduccionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListaReproduccionImpTest {
    @Mock
    private ListaReproduccionRepository repo;

    @InjectMocks
    private ListaReproduccionImpl service;

    @Test
    void testCrearLista() {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setNombre("Lista 1");

        when(repo.save(lista)).thenReturn(lista);

        ListaReproduccion result = service.crearLista(lista);
        assertEquals("Lista 1", result.getNombre());
    }

    @Test
    void testObtenerListaExistente() {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setNombre("Rock");

        when(repo.findById("Rock")).thenReturn(Optional.of(lista));

        Optional<ListaReproduccion> resultado = service.obtenerLista("Rock");

        assertTrue(resultado.isPresent());
        assertEquals("Rock", resultado.get().getNombre());
    }

    @Test
    void testEliminarListaExistente() {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setNombre("Pop");

        when(repo.findById("Pop")).thenReturn(Optional.of(lista));

        boolean eliminado = service.eliminarLista("Pop");

        assertTrue(eliminado);
        verify(repo, times(1)).delete(lista);
    }

    @Test
    void testEliminarListaInexistente() {
        when(repo.findById("Jazz")).thenReturn(Optional.empty());

        boolean eliminado = service.eliminarLista("Jazz");

        assertFalse(eliminado);
        verify(repo, never()).delete(any());
    }
}
