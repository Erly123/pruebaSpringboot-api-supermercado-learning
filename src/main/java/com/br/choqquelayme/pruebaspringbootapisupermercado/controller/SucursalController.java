package com.br.choqquelayme.pruebaspringbootapisupermercado.controller;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.ProductoDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.SucursalDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<SucursalDTO>> traerSucursal() {

        return ResponseEntity.ok(sucursalService.traerSucursal());
    }

    @PostMapping
    public ResponseEntity<SucursalDTO> created(@RequestBody SucursalDTO sucursalDTO) {
        SucursalDTO creado = sucursalService.crearSucursal(sucursalDTO);

        return ResponseEntity.created(URI.create("/api/sucursales" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDTO> update(@PathVariable Long id,
                                                          @RequestBody SucursalDTO sucursalDTO) {
        return ResponseEntity.ok(sucursalService.actualizarSucursal(id, sucursalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
