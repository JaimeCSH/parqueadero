package com.ceiba.servicio.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoServicio {

    private Long id;
    private Long vehiculo;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Integer activo;
    private BigDecimal valorAPagar;
    private Long horas;
}
