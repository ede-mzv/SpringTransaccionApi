package com.mitocode.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Transacciones")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Transaccion")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Cliente", referencedColumnName = "ID_Cliente")
    private Clientes clientes;


    @Column(name = "ID_Vehiculo")
    private Integer idVehiculo;

    @Column(name = "Fecha_Transaccion")
    private Timestamp fechaTransaccion;

    @Column(name = "Monto")
    private BigDecimal monto;

    @Column(name = "Transaccion_Realizada")
    private boolean transaccionRealizada;
}