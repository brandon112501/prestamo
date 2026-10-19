package com.example.prestamos.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "herramientas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "la categoria es obligatoria")
    private String categoria;

    @Min(value = 0, message = "la cantidad no puede ser negativa")
    private int cantidad;
}
