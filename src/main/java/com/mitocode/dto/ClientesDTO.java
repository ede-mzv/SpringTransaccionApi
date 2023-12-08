package com.mitocode.dto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientesDTO {
    @EqualsAndHashCode.Include
    private Integer id;

    @NotNull
    private String nombre;

    @NotNull
    private String tipo;

    @NotNull
    private String nacionalidad;

    @NotNull
    private String email;
}
