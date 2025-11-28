package com.br.choqquelayme.pruebaspringbootapisupermercado.repository;

import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
