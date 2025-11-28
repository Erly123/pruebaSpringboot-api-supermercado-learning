package com.br.choqquelayme.pruebaspringbootapisupermercado.repository;

import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
