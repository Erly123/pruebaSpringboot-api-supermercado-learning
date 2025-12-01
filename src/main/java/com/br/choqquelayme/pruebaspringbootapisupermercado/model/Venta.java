package com.br.choqquelayme.pruebaspringbootapisupermercado.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String estado;
    private Double total    ;

    @ManyToOne
    private Sucursal sucursal;

    @OneToMany 
    private List<DetalleVenta> detalle = new ArrayList<>();
}
