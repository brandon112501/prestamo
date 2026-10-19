package com.example.prestamos.Service;

import com.example.prestamos.DTO.PrestamoRequest;
import com.example.prestamos.Model.Prestamo;
import java.util.List;

public interface PrestamoService {
    List<Prestamo> listarPrestamos();
    List<Prestamo> listarPorHerramienta(Long herramientaId);
    Prestamo registrarPrestamo(PrestamoRequest request);
}