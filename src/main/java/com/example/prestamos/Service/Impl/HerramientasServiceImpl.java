package com.example.prestamos.Service.Impl;

import com.example.prestamos.Model.Herramienta;
import com.example.prestamos.Repository.HerramientaRepository;
import com.example.prestamos.Service.HerramientasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HerramientasServiceImpl implements HerramientasService {

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Override
    public List<Herramienta> listarHerramientas() {
        return herramientaRepository.findAll();
    }

    @Override
    public Optional<Herramienta> obtenerHerramientaPorId(Long id) {
        return herramientaRepository.findById(id);
    }

    @Override
    public Herramienta guardarHerramienta(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    @Override
    public Herramienta actualizarHerramienta(Long id, Herramienta detalles) {
        return herramientaRepository.findById(id).map(herramienta -> {
            herramienta.setNombre(detalles.getNombre());
            herramienta.setCategoria(detalles.getCategoria());
            herramienta.setCantidad(detalles.getCantidad());
            return herramientaRepository.save(herramienta);
        }).orElseThrow(() -> new RuntimeException("Herramienta no encontrada con id: " + id));
    }

    @Override
    public void eliminarHerramienta(Long id) {
        herramientaRepository.deleteById(id);
    }
}