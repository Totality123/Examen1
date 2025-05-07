package com.example.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.examen.models.Contenedor;

public interface ContenedorRepository extends JpaRepository<Contenedor, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}