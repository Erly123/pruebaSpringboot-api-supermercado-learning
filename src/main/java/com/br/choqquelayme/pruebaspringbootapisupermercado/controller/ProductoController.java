package com.br.choqquelayme.pruebaspringbootapisupermercado.controller;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.ProductoDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.service.IProductoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Gerenciador de productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> traerProductos () {

        return ResponseEntity.ok(productoService.traerProductos());
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> created(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO creado = productoService.crearProducto(productoDTO);

        return ResponseEntity.created(URI.create("/api/productos" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@PathVariable Long id,
                                                           @RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
