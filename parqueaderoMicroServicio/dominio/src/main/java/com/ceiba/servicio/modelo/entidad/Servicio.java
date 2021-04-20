package com.ceiba.servicio.modelo.entidad;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Servicio {

    private static final String SE_DEBE_ID_VEHICULO = "Se debe ingresar la id del vehiculo";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_ENTRADA = "Se debe ingresar fecha y hora de entrada";



    private Long id;
    private Long vehiculo;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Integer activo;
    private BigDecimal valorAPagar;
    private Long horas;

    public Servicio(Long id, Long vehiculo, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Integer activo,
    BigDecimal valorAPagar, Long horas) {
        validarObligatorio(vehiculo, SE_DEBE_ID_VEHICULO);
        validarObligatorio(fechaEntrada, SE_DEBE_INGRESAR_LA_FECHA_ENTRADA);

        this.id = id;
        this.vehiculo = vehiculo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.activo = activo;
        this.valorAPagar=valorAPagar;
        this.horas=horas;
    }

    public Servicio(Long id,Long vehiculo, LocalDateTime fechaEntrada ) {

        this.id = id;
        this.vehiculo=vehiculo;
        this.fechaEntrada= fechaEntrada;

    }

    public void setVehiculo(Long vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setHoras(Long horas) {
        this.horas = horas;
    }

    public void setActivo(int activo) {
        this.activo=activo;
    }

    public void setValorAPagar(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
    }
}
