package com.example.examen.services;

import com.example.examen.models.Barco;
import com.example.examen.repositories.BarcoRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BarcoService {

    private final BarcoRepository barcoRepository;

    public BarcoService(BarcoRepository barcoRepository) {
        this.barcoRepository = barcoRepository;
    }

    public List<Barco> obtenerTodos() {
        return barcoRepository.findAll();
    }

    public Optional<Barco> obtenerPorId(int id) {
        return barcoRepository.findById(id);
    }

    public Barco guardar(Barco barco) {
        return barcoRepository.save(barco);
    }

    public void eliminar(int id) {
        barcoRepository.deleteById(id);
    }
}