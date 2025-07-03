package com.paulapc.quipux_skills.rest;

import com.paulapc.quipux_skills.business.ListaReproduccionImpl;
import com.paulapc.quipux_skills.model.ListaReproduccion;
import com.paulapc.quipux_skills.repository.ListaReproduccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class ListaReproduccionController {

    private final ListaReproduccionImpl service;

    @PostMapping
    public ResponseEntity<?> crearLista(@RequestBody ListaReproduccion lista) {
        if (lista.getNombre() == null || lista.getNombre().isBlank()) {
            return ResponseEntity.badRequest().body("Nombre no válido");
        }
        ListaReproduccion creada = service.crearLista(lista);
        URI uri = URI.create("/lists/" + creada.getNombre());
        return ResponseEntity.created(uri).body(creada);
    }

    @GetMapping
    public ResponseEntity<List<ListaReproduccion>> listarListas() {
        return ResponseEntity.ok(service.listarListas());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> obtenerLista(@PathVariable String nombre) {
        return service.obtenerLista(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<?> eliminarLista(@PathVariable String nombre) {
        boolean eliminada = service.eliminarLista(nombre);
        return eliminada ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
