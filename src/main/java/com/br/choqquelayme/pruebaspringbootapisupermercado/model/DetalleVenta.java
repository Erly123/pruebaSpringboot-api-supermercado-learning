package com.br.choqquelayme.pruebaspringbootapisupermercado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.net.ssl.SSLSession;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="ventaId")
    private Venta venta;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="productoId")
    private Producto prod;
    private Integer cantProd;
    private Double precio;

}
