package com.example.examen.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Barcos")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Barco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40)
    private String nombre;

    @Column(length = 40)
    private String origen;

    @Column(length = 40)
    private String destino;

    @Column()
    private int capacidad;

    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Contenedor> contenedores;

}
