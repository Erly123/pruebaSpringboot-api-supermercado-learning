package com.br.choqquelayme.pruebaspringbootapisupermercado.service;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.DetalleVentaDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.VentaDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.exception.NotFoundException;
import com.br.choqquelayme.pruebaspringbootapisupermercado.mapper.Mapper;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.DetalleVenta;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Producto;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Sucursal;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Venta;
import com.br.choqquelayme.pruebaspringbootapisupermercado.repository.ProductoRepository;
import com.br.choqquelayme.pruebaspringbootapisupermercado.repository.SucursalRepository;
import com.br.choqquelayme.pruebaspringbootapisupermercado.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<VentaDTO> traerVentas() {

        List<Venta> ventas = ventaRepository.findAll();
        List<VentaDTO> ventasDto = new ArrayList<>();

        VentaDTO dto;
        for (Venta v : ventas) {
            dto = Mapper.toDTO(v);
            ventasDto.add (dto);
        }

        return ventasDto;
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {

        //Validaciones
        if (ventaDTO == null) throw new RuntimeException("VentaDTO es null");
        if (ventaDTO.getIdSucursal() == null) throw new RuntimeException("Debe indicar la sucursal");
        if (ventaDTO.getDetalle() == null || ventaDTO.getDetalle().isEmpty())
            throw new RuntimeException("Debe incluir al menos un producto");

        //Buscar la sucursal
        Sucursal suc = sucursalRepository.findById(ventaDTO.getIdSucursal()).orElse(null);
        if (suc == null) {
            throw new NotFoundException("Sucursal no encontrada");
        }

        //Crear la venta
        Venta vent = new Venta();
        vent.setFecha(ventaDTO.getFecha());
        vent.setEstado(ventaDTO.getEstado());
        vent.setSucursal(suc);
        vent.setTotal(ventaDTO.getTotal());

        // La lista de detalles
        // --> Acá están los productos
        List<DetalleVenta> detalles = new ArrayList<>();
        Double totalCalculado = 0.0;

        for (DetalleVentaDTO detDTO : ventaDTO.getDetalle()) {
            // Buscar producto por id (tu detDTO usa id como id de producto)
            Producto p = productoRepository.findByNombre(detDTO.getNombreProd()).orElse(null);
            if (p == null)
            {throw new RuntimeException("Producto no encontrado: " + detDTO.getNombreProd());}

            //Crear detalle
            DetalleVenta detalleVent = new DetalleVenta();
            detalleVent.setProd(p);
            detalleVent.setPrecio(detDTO.getPrecio());
            detalleVent.setCantProd(detDTO.getCantProd());
            detalleVent.setVenta(vent);

            detalles.add(detalleVent);
            totalCalculado = totalCalculado+(detDTO.getPrecio()*detDTO.getCantProd());

        }
        //Seteamos la lista de detalle Venta
        vent.setDetalle(detalles);

        //guardamos en la BD
        vent = ventaRepository.save(vent);

        //Mapeo de salida
        VentaDTO ventaSalida = Mapper.toDTO(vent);

        return ventaSalida;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventaDTO) {

        //buscar si la venta existe para actualizarla
        Venta v = ventaRepository.findById(id).orElse(null);
        if (v == null) throw new RuntimeException("Venta no encontrada");

        if (ventaDTO.getFecha()!=null) {
            v.setFecha(ventaDTO.getFecha());
        }
        if(ventaDTO.getEstado()!=null) {
            v.setEstado(ventaDTO.getEstado());
        }

        if (ventaDTO.getTotal()!=null) {
            v.setTotal(ventaDTO.getTotal());
        }

        if (ventaDTO.getIdSucursal()!=null) {
            Sucursal suc = sucursalRepository.findById(ventaDTO.getIdSucursal()).orElse(null);
            if (suc == null) throw new NotFoundException("Sucursal no encontrada");
            v.setSucursal(suc);
        }
        ventaRepository.save(v);

        VentaDTO ventaSalida = Mapper.toDTO(v);

        return ventaSalida;
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta v = ventaRepository.findById(id).orElse(null);
        if (v == null) throw new RuntimeException("Venta no encontrada");
        ventaRepository.delete(v);
    }
}
