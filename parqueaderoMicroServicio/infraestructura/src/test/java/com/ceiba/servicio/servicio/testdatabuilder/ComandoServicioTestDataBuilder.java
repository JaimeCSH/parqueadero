package com.ceiba.servicio.servicio.testdatabuilder;

import com.ceiba.servicio.comando.ComandoServicio;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.ComandoVehiculoTestDataBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoServicioTestDataBuilder {

    private Long id;
    private Long vehiculo;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Integer activo;
    private BigDecimal valorAPagar;
    private Long horas;

    public ComandoServicioTestDataBuilder(){
        vehiculo = 2L;
    }

    public ComandoServicioTestDataBuilder conVehiculo(Long vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }

    public ComandoServicio build() {
        return new ComandoServicio(id,vehiculo,fechaEntrada,fechaSalida,activo,valorAPagar,horas);
    }

}
