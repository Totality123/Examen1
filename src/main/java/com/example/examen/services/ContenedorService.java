package com.example.examen.services;

import com.example.examen.models.Contenedor;
import com.example.examen.repositories.ContenedorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContenedorService {
    private final ContenedorRepository contenedorRepository;

    public ContenedorService(ContenedorRepository contenedorRepository) {
        this.contenedorRepository = contenedorRepository;
    }

    public List<Contenedor> obtenerTodos() {
        return contenedorRepository.findAll();
    }

    public Optional<Contenedor> obtenerPorId(int id) {
        return contenedorRepository.findById(id);
    }

    public Contenedor guardar(Contenedor contenedor) {
        return contenedorRepository.save(contenedor);
    }

    public void eliminar(int id) {
        contenedorRepository.deleteById(id);
    }

    public List<Contenedor> obtenerPorBarcoId(int barcoId) {
        return contenedorRepository.findByBarcoId(barcoId);
    }    
}