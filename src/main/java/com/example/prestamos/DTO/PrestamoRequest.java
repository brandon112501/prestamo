package com.example.prestamos.DTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class PrestamoRequest {

    @NotBlank(message = "El responsable es obligatorio")
    private String responsable;

    @NotNull (message= "la fecha es obligatoria")
    private LocalDate fechaPrestamo;

    @Min(value = 1, message = "La cantidad minima es 1")
    private int cantidad;


    @NotNull(message = "El Id de la herramienta es obligatoria")
    private Long herramientaId;
}
