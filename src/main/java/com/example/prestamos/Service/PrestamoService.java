package com.example.prestamos.Service;

import com.example.prestamos.Model.Prestamo;
import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    List<Prestamo> listarPrestamos();
    Optional<Prestamo> obtenerPrestamoPorId(Long id);
    Prestamo guardarPrestamo(Prestamo prestamo);
    Prestamo actualizarPrestamo(Long id, Prestamo detalles);
    void eliminarPrestamo(Long id);
}