package com.br.choqquelayme.pruebaspringbootapisupermercado.service;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.SucursalDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.exception.NotFoundException;
import com.br.choqquelayme.pruebaspringbootapisupermercado.mapper.Mapper;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Sucursal;
import com.br.choqquelayme.pruebaspringbootapisupermercado.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService{

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> traerSucursal() {
        return sucursalRepository.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {
        Sucursal suc = Sucursal.builder()
                .nombre(sucursalDTO.getNombre())
                .direccion(sucursalDTO.getDireccion())
                .build();

        return Mapper.toDTO(sucursalRepository.save(suc));
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDTO) {
        Sucursal suc = sucursalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sucursal no encontrada"));

        suc.setNombre(sucursalDTO.getNombre());
        suc.setDireccion(sucursalDTO.getDireccion());

        return Mapper.toDTO(sucursalRepository.save(suc));
    }

    @Override
    public void eliminarSucursal(Long id) {
        if (!sucursalRepository.existsById(id))
            throw new NotFoundException("Sucursal no encontrada");
        sucursalRepository.deleteById(id);
    }

}
