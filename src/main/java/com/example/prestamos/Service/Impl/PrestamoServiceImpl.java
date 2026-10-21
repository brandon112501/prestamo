package com.example.prestamos.Service.Impl;

import com.example.prestamos.DTO.PrestamoRequest;
import com.example.prestamos.Model.Prestamo;
import com.example.prestamos.Repository.PrestamoRepository;
import com.example.prestamos.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Optional<Prestamo> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public Prestamo guardarPrestamo(PrestamoRequest request) {
        return null;
    }

    @Override
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizarPrestamo(Long id, Prestamo detalles) {
        return prestamoRepository.findById(id).map(prestamo -> {
            prestamo.setResponsable(detalles.getResponsable());
            prestamo.setFechaPrestamo(detalles.getFechaPrestamo());
            prestamo.setCantidad(detalles.getCantidad());
            prestamo.setHerramienta(detalles.getHerramienta());
            return prestamoRepository.save(prestamo);
        }).orElseThrow(() -> new RuntimeException("Prestamo no encontrado con id: " + id));
    }
    @Override
    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }
}