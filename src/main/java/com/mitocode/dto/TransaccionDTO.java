package com.mitocode.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TransaccionDTO {
    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    private ClientesDTO cliente;


    private Integer idVehiculo;

    private Integer diasReserva;

    private String direccionEntrega;

    private boolean transaccionRealizada;

}
