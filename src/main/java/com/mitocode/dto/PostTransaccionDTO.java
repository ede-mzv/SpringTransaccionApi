package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostTransaccionDTO {
    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    private Integer clienteId;


    @NotNull
    private Timestamp fechaTransaccion;

    @NotNull
    private BigDecimal monto;

}
