package com.example.examen.models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Contenedor")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contenedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 11, nullable= false)
    private String vin;

    @Column
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_Barco")
    private Barco barco;
}
