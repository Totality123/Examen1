package com.example.examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.examen.models.Contenedor;

public interface ContenedorRepository extends JpaRepository<Contenedor, Integer> {
       
    List<Contenedor> findByBarcoId(int barcoId);

}