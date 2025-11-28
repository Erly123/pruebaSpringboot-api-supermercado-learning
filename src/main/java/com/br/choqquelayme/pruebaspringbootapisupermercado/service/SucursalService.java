package com.br.choqquelayme.pruebaspringbootapisupermercado.service;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.SucursalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService{
    @Override
    public List<SucursalDTO> traerSucursal() {
        return List.of();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {
        return null;
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO) {
        return null;
    }

    @Override
    public void eliminarSucursal(Long id) {

    }
}
