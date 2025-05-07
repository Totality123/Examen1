package com.example.examen.controllers;

import com.example.examen.models.Contenedor;
import com.example.examen.services.ContenedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contenedores")
public class ContenedorController {
    private final ContenedorService contenedorService;

    public ContenedorController(ContenedorService contenedorService) {
        this.contenedorService = contenedorService;
    }

    @GetMapping
    public List<Contenedor> obtenerTodos() {
        return contenedorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Contenedor> obtenerPorId(@PathVariable int id) {
        return contenedorService.obtenerPorId(id);
    }

    @PostMapping
    public Contenedor guardar(@RequestBody Contenedor contenedor) {
        return contenedorService.guardar(contenedor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        contenedorService.eliminar(id);
    }

    @GetMapping("/barco/{barcoId}")
    public List<Contenedor> obtenerPorBarcoId(@PathVariable int barcoId) {
        return contenedorService.obtenerPorBarcoId(barcoId);
    }
}