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
    @GetMapping("/{id}")
    public ResponseEntity<Herramienta> consultarHerramientaPorId(@PathVariable Long id) {
        return herramientasService.obtenerHerramientaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Herramienta> actualizarHerramienta(@PathVariable Long id, @RequestBody Herramienta herramienta) {
        try {
            Herramienta actualizada = herramientasService.actualizarHerramienta(id, herramienta);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHerramienta(@PathVariable Long id) {
        herramientasService.eliminarHerramienta(id);
        return ResponseEntity.noContent().build();
    }
}