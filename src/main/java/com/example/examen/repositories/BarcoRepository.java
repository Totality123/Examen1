package com.example.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.examen.models.Barco;

public interface BarcoRepository extends JpaRepository<Barco, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}