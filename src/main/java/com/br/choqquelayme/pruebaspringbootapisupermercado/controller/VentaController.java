package com.br.choqquelayme.pruebaspringbootapisupermercado.controller;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.VentaDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDTO>> traerVentas() {
        return ResponseEntity.ok(ventaService.traerVentas());
    }

    @PostMapping
    public ResponseEntity<VentaDTO> created(@RequestBody VentaDTO ventaDTO) {
        VentaDTO creado = ventaService.crearVenta(ventaDTO);
        return ResponseEntity.created(URI.create("/api/ventas/" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDTO> update(@PathVariable Long id, @RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.ok(ventaService.actualizarVenta(id,ventaDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }
}

