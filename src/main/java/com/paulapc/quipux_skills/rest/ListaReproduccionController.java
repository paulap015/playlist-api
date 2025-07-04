package com.paulapc.quipux_skills.rest;

import com.paulapc.quipux_skills.business.ListaReproduccionImpl;
import com.paulapc.quipux_skills.model.ListaReproduccion;
import com.paulapc.quipux_skills.repository.ListaReproduccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Controlador que expone los endpoints para gestionar las listas de reproducción.
 */
@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class ListaReproduccionController {

    private final ListaReproduccionImpl service;

    /**
     * Crea una nueva lista de reproducción.
     * @param lista Objeto con nombre, descripción y canciones.
     * @return ResponseEntity con la lista creada.
     */
    @PostMapping
    public ResponseEntity<?> crearLista(@RequestBody ListaReproduccion lista) {
        if (lista.getNombre() == null || lista.getNombre().isBlank()) {
            return ResponseEntity.badRequest().body("Nombre no válido");
        }
        ListaReproduccion creada = service.crearLista(lista);

        return ResponseEntity.ok(creada);
    }

    /**
     * listar todas las playlist
     * @return ResponseEntity con la lista
     */
    @GetMapping
    public ResponseEntity<List<ListaReproduccion>> listarListas() {
        return ResponseEntity.ok(service.listarListas());
    }

    /**
     * Obtener una playlist por el nombre
     * @param nombre de la playlist
     * @return ResponseEntity ok o notfound si no la encuentra
     */
    @GetMapping("/{nombre}")
    public ResponseEntity<?> obtenerLista(@PathVariable String nombre) {
        return service.obtenerLista(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Eliminar por el nombre de la playlist
     * @param nombre nombre playlist
     * @return ResponseEntity nocontent al eliminar si no lo encuentra notfound
     */
    @DeleteMapping("/{nombre}")
    public ResponseEntity<?> eliminarLista(@PathVariable String nombre) {
        boolean eliminada = service.eliminarLista(nombre);
        return eliminada ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
