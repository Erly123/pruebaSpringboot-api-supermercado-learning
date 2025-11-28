package com.br.choqquelayme.pruebaspringbootapisupermercado.service;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Override
    public List<VentaDTO> traerVentas() {
        return List.of();
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {
        return null;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventaDTO) {
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

    }
}
