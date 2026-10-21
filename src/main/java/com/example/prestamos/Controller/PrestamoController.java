package com.example.prestamos.Controller;

import com.example.prestamos.Model.Prestamo;
import com.example.prestamos.Service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    // 1. LISTAR TODOS
    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.listarPrestamos();
    }

    // 2. BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> consultarPrestamoPorId(@PathVariable Long id) {
        return prestamoService.obtenerPrestamoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR / REGISTRAR
    @PostMapping
    public ResponseEntity<Prestamo> registrarPrestamo(@Valid @RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.guardarPrestamo(prestamo));
    }

    // 4. ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        try {
            Prestamo actualizado = prestamoService.actualizarPrestamo(id, prestamo);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }
}