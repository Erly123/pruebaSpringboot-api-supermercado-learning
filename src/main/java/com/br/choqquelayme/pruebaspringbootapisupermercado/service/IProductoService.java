package com.br.choqquelayme.pruebaspringbootapisupermercado.service;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);
    void eliminarProducto(Long id);
}
