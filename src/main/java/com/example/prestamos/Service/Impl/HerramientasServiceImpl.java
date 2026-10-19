package com.example.prestamos.Service.Impl;

import com.example.prestamos.Model.Herramienta;
import com.example.prestamos.Repository.HerramientaRepository;
import com.example.prestamos.Service.HerramientasService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HerramientasServiceImpl implements HerramientasService {

    private final HerramientaRepository herramientaRepository;

    public HerramientasServiceImpl(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }

    @Override
    public List<Herramienta> listarHerramientas() {
        return herramientaRepository.findAll();
    }

    @Override
    public Herramienta guardarHerramienta(Herramienta herramienta) {
        if (herramienta.getCantidad() < 0) {
            throw new IllegalArgumentException("No se permiten cantidades negativas.");
        }
        return herramientaRepository.save(herramienta);
    }
}