package com.example.prestamos.Controller;

import com.example.prestamos.Model.Herramienta;
import com.example.prestamos.Service.HerramientasService; // Asegúrate de que importe la interfaz correcta
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@CrossOrigin(origins = "*")
public class HerramientaController {

    private final HerramientasService herramientasService;

    public HerramientaController(HerramientasService herramientasService) {
        this.herramientasService = herramientasService;
    }

    @GetMapping
    public List<Herramienta> consultarHerramientas() {
        return herramientasService.listarHerramientas();
    }

    @PostMapping
    public ResponseEntity<Herramienta> registrarHerramienta(@Valid @RequestBody Herramienta herramienta) {
        return ResponseEntity.ok(herramientasService.guardarHerramienta(herramienta));
    }
}