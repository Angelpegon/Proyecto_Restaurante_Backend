package com.example.Restaurante.Modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
@Table(name = "meseros")
public class Meseros implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meseros_generator")
    @SequenceGenerator(name = "meseros_generator", sequenceName = "meseros_seq", allocationSize = 1)
    private Long id;
    private String nombre;
}
