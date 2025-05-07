package com.example.examen.controllers;

import com.example.examen.models.Barco;
import com.example.examen.services.BarcoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/barcos")
public class BarcoController {
    
    private BarcoService barcoService;

    @GetMapping
    public List<Barco> obtenerTodos() {
        return barcoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Barco> obtenerPorId(@PathVariable int id) {
        return barcoService.obtenerPorId(id);
    }

    @PostMapping
    public Barco guardar(@RequestBody Barco barco) {
        return barcoService.guardar(barco);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        barcoService.eliminar(id);
    }
}