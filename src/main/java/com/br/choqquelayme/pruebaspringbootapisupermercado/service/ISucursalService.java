package com.br.choqquelayme.pruebaspringbootapisupermercado.service;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {
    List<SucursalDTO> traerSucursal();
    SucursalDTO crearSucursal(SucursalDTO sucursalDTO);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO);
    void eliminarSucursal(Long id);
}
