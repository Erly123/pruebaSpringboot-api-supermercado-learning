package com.br.choqquelayme.pruebaspringbootapisupermercado.controller;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.VentaDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.service.IVentaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@Tag(name = "Ventas", description = "Gerenciador de Ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    @Operation(summary = "Listar ventas",description = "Lista todas las venta de la base de memoria temporal y dura solamente el tiempo de ejecucion!")
    public ResponseEntity<List<VentaDTO>> traerVentas() {
        return ResponseEntity.ok(ventaService.traerVentas());
    }

    @PostMapping
    @Operation(summary = "Resgistra venta",description = "Registra una nueva venta en la base de memoria temporal y dura solamente el tiempo de ejecucion!")
    public ResponseEntity<VentaDTO> created(@RequestBody VentaDTO ventaDTO) {
        VentaDTO creado = ventaService.crearVenta(ventaDTO);
        return ResponseEntity.created(URI.create("/api/ventas/" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = " Actualizar venta",description = "Actualiza una venta en la base de memoria temporal y dura solamente el tiempo de ejecucion!")
    public ResponseEntity<VentaDTO> update(@PathVariable Long id, @RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.ok(ventaService.actualizarVenta(id,ventaDTO));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar venta",description = "Elimina una venta en la base de memoria temporal y dura solamente el tiempo de ejecucion!")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }
}

