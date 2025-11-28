package com.br.choqquelayme.pruebaspringbootapisupermercado.mapper;

import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.DetalleVentaDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.ProductoDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.SucursalDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.dto.VentaDTO;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Producto;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Sucursal;
import com.br.choqquelayme.pruebaspringbootapisupermercado.model.Venta;

import java.util.stream.Collectors;

public class Mapper {
    public static ProductoDTO toDTO(Producto p) {
        if(p == null) return null;

        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .cantidad(p.getCantidad())
                .build();
    }

    public static SucursalDTO toDTO(Sucursal p) {
        if(p == null) return null;

        return SucursalDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .direccion(p.getDireccion())
                .build();
    }

    public static VentaDTO toDTO(Venta venta) {
        if (venta == null) return null;

        var detalle = venta.getDetalle().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getProd().getId())
                        .nombreProd(det.getProd().getNombre())
                        .cantProd(det.getCantProd())
                        .precio(det.getPrecio())
                        .subtotal(det.getPrecio() * det.getCantProd())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .idSucursal(venta.getSucursal().getId())
                .estado(venta.getEstado())
                .detalle(detalle)
                .total(total)
                .build();
    }
}
