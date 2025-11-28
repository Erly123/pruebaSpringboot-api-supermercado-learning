package com.br.choqquelayme.pruebaspringbootapisupermercado.repository;

import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
