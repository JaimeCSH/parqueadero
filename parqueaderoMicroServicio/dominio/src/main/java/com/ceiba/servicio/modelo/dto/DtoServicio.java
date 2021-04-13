package com.ceiba.servicio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoServicio {

    private Long id;
    private Long vehiculo;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Integer activo;
    private BigDecimal volorAPagar;
    private Long horas;
}
