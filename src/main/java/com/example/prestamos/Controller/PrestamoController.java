package com.example.prestamos.Controller;

import com.example.prestamos.DTO.PrestamoRequest;
import com.example.prestamos.Model.Prestamo;
import com.example.prestamos.Service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*")
public class PrestamoController {

    private final PrestamoService prestamoService;

    // Inyección por constructor sin @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<Prestamo> consultarPrestamos() {
        return prestamoService.listarPrestamos();
    }

    @GetMapping("/herramienta/{id}")
    public List<Prestamo> consultarPorHerramienta(@PathVariable Long id) {
        return prestamoService.listarPorHerramienta(id);
    }

    @PostMapping
    public ResponseEntity<?> registrarPrestamo(@Valid @RequestBody PrestamoRequest request) {
        try {
            Prestamo prestamo = prestamoService.registrarPrestamo(request);
            return ResponseEntity.ok(prestamo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}