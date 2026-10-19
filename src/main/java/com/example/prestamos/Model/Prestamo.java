package com.example.prestamos.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el responsable es obligatorio")
    private String responsable;

    @NotNull
    private LocalDate fechaPrestamo;

    @Min(value = 1, message = "la cantidad debe ser al menos 1")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name= "herramienta_id",nullable = false)
    private Herramienta herramienta;
}


