package com.example.prestamos.Service;

import com.example.prestamos.Model.Herramienta;
import java.util.List;

public interface HerramientasService {
    List<Herramienta> listarHerramientas();
    Herramienta guardarHerramienta(Herramienta herramienta);
}