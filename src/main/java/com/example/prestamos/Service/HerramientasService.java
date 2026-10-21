package com.example.prestamos.Service;

import com.example.prestamos.Model.Herramienta;
import java.util.List;
import java.util.Optional;

public interface HerramientasService {
    List<Herramienta> listarHerramientas();
    Optional<Herramienta> obtenerHerramientaPorId(Long id);
    Herramienta guardarHerramienta(Herramienta herramienta);
    Herramienta actualizarHerramienta(Long id, Herramienta detalles);
    void eliminarHerramienta(Long id);
}