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
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String estado;

    @ManyToOne
    private Sucursal sucursal;

    @OneToMany (mappedBy = "venta", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetalleVenta> detalle = new ArrayList<>();

    private Double total;
}
