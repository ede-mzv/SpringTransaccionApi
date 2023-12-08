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


    private ClientesDTO cliente;


    private Integer idVehiculo;

    @NotNull
    private Timestamp fechaTransaccion;

    @NotNull
    private BigDecimal monto;

    private boolean transaccionRealizada;

}
